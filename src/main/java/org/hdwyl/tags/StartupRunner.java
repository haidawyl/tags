package org.hdwyl.tags;

import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.datasource.MongoClient;
import org.hdwyl.tags.datasource.SolrClient;
import org.hdwyl.tags.domain.DataSource;
import org.hdwyl.tags.domain.DictIndustry;
import org.hdwyl.tags.mapper.DataSourceMapper;
import org.hdwyl.tags.mapper.DictIndustryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Autowired
    private DictIndustryMapper dictIndustryMapper;

    @Override
    public void run(String... args) throws Exception {
        List<DataSource> dataSourceList = dataSourceMapper.queryAll();
        for (DataSource dataSource : dataSourceList) {
            if (StringUtils.equalsIgnoreCase(dataSource.getStorageType(), Constants.StorageType.SOLR.getName())) {
                SolrClient solrClient = new SolrClient(dataSource.getHost(), dataSource.getPort(), dataSource.getUsername(), dataSource.getPassword(), dataSource.getSchema());
                Constants.DATASOURCE.put(dataSource.getId(), solrClient);
            } else if (StringUtils.equalsIgnoreCase(dataSource.getStorageType(), Constants.StorageType.MONGODB.getName())) {
                MongoClient mongoClient = new MongoClient(dataSource.getHost(), dataSource.getPort(), dataSource.getUsername(), dataSource.getPassword(), dataSource.getSchema());
                Constants.DATASOURCE.put(dataSource.getId(), mongoClient);
            }
        }

        List<DictIndustry> dictIndustries = dictIndustryMapper.queryDictAndParent();
        for (DictIndustry dictIndustry : dictIndustries) {
            String name = dictIndustry.getText().trim();
            Constants.INDUSTRY.put(name,dictIndustry);
        }
    }
}
