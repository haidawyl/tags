package org.hdwyl.tags.service.impl;

import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.datasource.SolrClient;
import org.hdwyl.tags.domain.*;
import org.hdwyl.tags.mapper.DataSourceMapper;
import org.hdwyl.tags.mapper.DictAreaMapper;
import org.hdwyl.tags.mapper.ThemeColumnMapper;
import org.hdwyl.tags.service.BaseService;
import org.hdwyl.tags.service.CityIndustryCountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.response.FacetField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityIndustryCountImpl extends BaseService implements CityIndustryCountService {

    @Autowired
    protected DictAreaMapper dictAreaMapper;

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Autowired
    private ThemeColumnMapper themeColumnMapper;

    public List<DictArea> getProvinces() {
        return dictAreaMapper.queryDict(" parent is null");
    }

    public List<DictArea> getCitys(String province) {
        return dictAreaMapper.queryDict(" parent=" + province);
    }

    public List<CityIndustryCount> queryByFacet(String query, String[] facetFields, String province, String city, String provinceCode, String cityCode) {
        List<DataSource> dataSourceList = dataSourceMapper.queryAll();
        List<FacetField> list = new ArrayList<>();
        for (DataSource dataSource : dataSourceList) {
            if (StringUtils.equalsIgnoreCase(dataSource.getStorageType(), Constants.StorageType.SOLR.getName())) {
                SolrClient solrClient = (SolrClient) Constants.DATASOURCE.get(dataSource.getId());
//                SolrClient solrClient = new SolrClient(dataSource.getHost(), dataSource.getPort(), dataSource.getUsername(), dataSource.getPassword(), dataSource.getSchema());
                list = solrClient.queryByFacet(query, facetFields);
                break;
            }
        }
        List<CityIndustryCount> cityIndustryCounts = new ArrayList<>();
        for (FacetField facet : list) {
            List<FacetField.Count> counts = facet.getValues();
            for (FacetField.Count count : counts) {
                long c = count.getCount();
                if (c == 0) {
                    continue;
                }
                CityIndustryCount cityIndustryCount = new CityIndustryCount();
                cityIndustryCount.setName(count.getName());
                DictIndustry dictIndustry = (DictIndustry)Constants.INDUSTRY.get(count.getName());

                cityIndustryCount.setCode(dictIndustry.getValue());
                cityIndustryCount.setPname(dictIndustry.getPtext());
                cityIndustryCount.setCount(count.getCount());
                cityIndustryCount.setProvince(province);
                cityIndustryCount.setCity(city);
                cityIndustryCount.setProvinceCode(provinceCode);
                cityIndustryCount.setCityCode(cityCode);
                cityIndustryCounts.add(cityIndustryCount);
            }
        }
        return cityIndustryCounts;
    }

    @Override
    public String getDefaultColumns(Integer themeId, Integer status) {
        StringBuffer columns = new StringBuffer();
        List<ThemeColumn> columnList = themeColumnMapper.queryDefaultByTheme(themeId, status);
        for (ThemeColumn themeColumn : columnList) {
            columns.append(themeColumn.getColumn()).append(",");
        }
        return columns.substring(0, columns.length() - 1);
    }
}
