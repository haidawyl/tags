package org.hdwyl.tags.service.impl;

import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.datasource.MongoClient;
import org.hdwyl.tags.datasource.SolrClient;
import org.hdwyl.tags.service.BaseService;
import org.hdwyl.tags.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.bson.Document;
import org.hdwyl.tags.domain.*;
import org.hdwyl.tags.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchServiceImpl extends BaseService implements SearchService {

    protected static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    protected TagLocationMapper tagLocationMapper;

    @Autowired
    protected DictMappingMapper dictMappingMapper;

    @Autowired
    private DictCommonMapper dictCommonMapper;

    @Autowired
    protected DictAreaMapper dictAreaMapper;

    @Autowired
    protected DictIndustryMapper dictIndustryMapper;

    @Autowired
    protected DataSourceMapper dataSourceMapper;

    @Autowired
    protected ThemeColumnMapper themeColumnMapper;

    @Autowired
    protected SearchHistoryMapper searchHistoryMapper;

    @Override
    public List<Map<String, Object>> getColumns(Integer themeId, String[] columns) {
        List<Map<String, Object>> columnList = new ArrayList<Map<String, Object>>();
        for (String column : columns) {
            ThemeColumn themeColumn = themeColumnMapper.queryByPk(themeId, column);
            Map<String, Object> columnMap = new HashMap<String, Object>();
            columnMap.put("field", StringUtils.substring(themeColumn.getColumn(), StringUtils.lastIndexOf(themeColumn.getColumn(), ".") + 1));
            columnMap.put("title", themeColumn.getTitle());
            columnMap.put("width", themeColumn.getWidth());
            columnMap.put("visible", themeColumn.getVisible() == 1);
            columnList.add(columnMap);
        }
        return columnList;
    }

    @Override
    public List<Map<String, Object>> getColumns(Integer themeId, Integer status) {
        List<ThemeColumn> themeColumnList = themeColumnMapper.queryByTheme(themeId, status);
        List<Map<String, Object>> columnList = new ArrayList<Map<String, Object>>();
        for (ThemeColumn themeColumn : themeColumnList) {
            Map<String, Object> columnMap = new HashMap<String, Object>();
            columnMap.put("field", StringUtils.substring(themeColumn.getColumn(), StringUtils.lastIndexOf(themeColumn.getColumn(), ".") + 1));
            columnMap.put("title", themeColumn.getTitle());
            columnMap.put("width", themeColumn.getWidth());
            columnMap.put("visible", themeColumn.getVisible() == 1);
            columnList.add(columnMap);
        }
        return columnList;
    }

    @Override
    public List<?> search(Integer themeId, String columns, String conditions, String sort, Integer limit, String remark) {
        StringBuffer query = new StringBuffer();
        StringBuffer filterQuery = new StringBuffer();

        String storageType = null;
        Integer dsId = null;
        // conditions: 定位ID 值类型 比较操作符 值;定位ID 值类型 比较操作符 值
        // 例如: 1002 Dict-Province = 370000;1003 Dict-City = 370900;1005 Dict-IndustryL1 = K
        String[] conditionArr = StringUtils.split(conditions, ";");
        for (int i = 0; i < conditionArr.length; i++) {
            String condition = conditionArr[i];
            String[] items = StringUtils.split(condition, " ");
            TagLocation tagLocation = tagLocationMapper.queryByPk(Integer.parseInt(items[0]));
            if (storageType == null) {
                dsId = tagLocation.getDsId();
                DataSource dataSource = dataSourceMapper.queryByPk(dsId);
                storageType = dataSource.getStorageType();
            }

            if (StringUtils.equalsIgnoreCase(storageType, Constants.StorageType.SOLR.getName())) {
                query.append(tagLocation.getColumn());
                if (StringUtils.startsWithIgnoreCase(items[1], Constants.ValueType.DICT.getName())) {
                    query.append(":");

                    String keyword = items[1].substring(items[1].indexOf("-") + 1);
                    List<DictMapping> dictMappingList = dictMappingMapper.query(keyword);
                    if (dictMappingList.size() == 1) {
                        DictMapping dictMapping = dictMappingList.get(0);
                        if (StringUtils.equals(dictMapping.getTable(), "dict_area")) {
                            DictArea area = dictAreaMapper.queryByPk(items[3]);
                            query.append("\"").append(area.getAreaName()).append("\"");
                        } else if (StringUtils.equals(dictMapping.getTable(), "dict_industry")) {
                            DictIndustry industry = dictIndustryMapper.queryByPk(items[3]);
                            query.append("\"").append(industry.getName()).append("\"");
                        } else {
                            DictCommon dict = dictCommonMapper.query(keyword, Integer.parseInt(items[3]));
                            query.append(dict.getName());
                        }
                    }
                } else if (StringUtils.equalsIgnoreCase(items[1], Constants.ValueType.STRING.getName())) {
                    query.append(":").append("\"").append(items[3]).append("\"");
                } else if (StringUtils.equalsIgnoreCase(items[1], Constants.ValueType.INTEGER.getName())
                        || StringUtils.equalsIgnoreCase(items[1], Constants.ValueType.DOUBLE.getName())) {
                    query.append(":");
                    if (StringUtils.equalsIgnoreCase(items[2].trim(), "=")) {
                        query.append(items[3]);
                    } else if (StringUtils.equalsIgnoreCase(items[2].trim(), "!=")) {
                        query.append("[* TO *]");
                        filterQuery.append("-").append(tagLocation.getColumn()).append(":").append(items[3]);
                    } else {
                        query.append("[");
                        if (StringUtils.equalsIgnoreCase(items[2].trim(), ">")) {
                            query.append(items[3]).append(" TO *");
                            filterQuery.append("-").append(tagLocation.getColumn()).append(":").append(items[3]);
                        } else if (StringUtils.equalsIgnoreCase(items[2].trim(), ">=")) {
                            query.append(items[3]).append(" TO *");
                        } else if (StringUtils.equalsIgnoreCase(items[2].trim(), "<")) {
                            query.append("* TO ").append(items[3]);
                            filterQuery.append("-").append(tagLocation.getColumn()).append(":").append(items[3]);
                        } else if (StringUtils.equalsIgnoreCase(items[2].trim(), "<=")) {
                            query.append("* TO ").append(items[3]);
                        } else if (StringUtils.equalsIgnoreCase(items[2].trim(), "between")) {
                            query.append(items[3].replace(",", " TO "));
                        }
                        query.append("]");
                    }
                } else if (StringUtils.equalsIgnoreCase(items[1], Constants.ValueType.DATE.getName())) {
                    query.append(":[");
                    if (items.length == 5) {
                        query.append(items[3]).append("T00:00:00Z TO *");
                    } else if (items.length == 6) {
                        query.append("* TO ").append(items[4]).append("T00:00:00Z");
                    } else if (items.length == 7) {
                        query.append(items[3]).append("T00:00:00Z TO ").append(items[5]).append("T00:00:00Z");
                    }
                    query.append("]");
                }

                if (i < conditionArr.length - 1) {
                    query.append(" ").append(items[items.length - 1]).append(" ");
                }
            }
        }

        List<String> relatedColumnList = new ArrayList<String>();
        Map<Integer, Map<String, String>> slaveDsColumnMap = new LinkedHashMap<Integer, Map<String, String>>();
        List<String> fieldList = new ArrayList<String>();

        List<ThemeColumn> themeColumnList = themeColumnMapper.queryByTheme(themeId, Constants.Status.VALID.getValue());
        Map<String, ThemeColumn> themeColumnMap = new LinkedHashMap<String, ThemeColumn>();
        for (ThemeColumn themeColumn : themeColumnList) {
            if (themeColumn.getRelatedKey() == 1) {
                relatedColumnList.add(themeColumn.getColumn());
            }
            themeColumnMap.put(themeColumn.getColumn(), themeColumn);
        }

        if (StringUtils.isEmpty(columns)) {
            columns = StringUtils.join(themeColumnMap.keySet().toArray(), ",");
        }

        String[] displayColumnArr = StringUtils.split(columns, ",");
        for (String column : displayColumnArr) {
            if (themeColumnMap.get(column).getDsId() == dsId) {
                fieldList.add(column);
            } else {
                Map<String, String> tableColumnMap = slaveDsColumnMap.get(themeColumnMap.get(column).getDsId());
                if (tableColumnMap == null) {
                    tableColumnMap = new LinkedHashMap<String, String>();
                    slaveDsColumnMap.put(themeColumnMap.get(column).getDsId(), tableColumnMap);
                }

                String tableName = themeColumnMap.get(column).getTable();
                String tableColumns = tableColumnMap.get(tableName);
                if (StringUtils.isEmpty(tableColumns)) {
                    tableColumns = "";
                }
                tableColumnMap.put(themeColumnMap.get(column).getTable(), StringUtils.join(tableColumns, ",", column));
            }
        }

        List<Map<String, Object>> recordList = null;
        if (StringUtils.equalsIgnoreCase(storageType, Constants.StorageType.SOLR.getName())) {
            SolrClient solrClient = (SolrClient) Constants.DATASOURCE.get(dsId);

            String[] sortArr = StringUtils.split(sort, " ");
            Integer sortFieldId = Integer.parseInt(sortArr[0]);
            String order = sortArr[1];
            TagLocation tagLocation = tagLocationMapper.queryByPk(sortFieldId);
            String sortFieldName = tagLocation.getColumn();

            String[] fields = new String[fieldList.size()];
            fields = fieldList.toArray(fields);
            recordList = solrClient.query(query.toString(), filterQuery.toString(), sortFieldName, order, 0, limit, fields);
        }

        for (Integer slaveDsId : slaveDsColumnMap.keySet()) {
            for (Map<String, Object> record : recordList) {
                Map<String, String> tableColumnMap = slaveDsColumnMap.get(slaveDsId);
                DataSource dataSource = dataSourceMapper.queryByPk(slaveDsId);
                if (StringUtils.equalsIgnoreCase(dataSource.getStorageType(), Constants.StorageType.MONGODB.getName())) {
                    MongoClient mongoClient = (MongoClient) Constants.DATASOURCE.get(slaveDsId);

                    Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
                    for (String column : relatedColumnList) {
                        queryMap.put(column, record.get(column));
                    }

                    for (String table : tableColumnMap.keySet()) {
                        String tableColumns = tableColumnMap.get(table);
                        Document document = mongoClient.findOne(table, queryMap, StringUtils.split(tableColumns, ","));
                        for (String column : StringUtils.split(tableColumns, ",")) {
                            Object value = null;
                            String[] columnItems = StringUtils.split(column, ".");

                            Document childDocument = document;
                            for (int i = 0; i < columnItems.length; i++) {
                                if (i < columnItems.length - 1) {
                                    childDocument = (Document) childDocument.get(columnItems[i]);
                                } else {
                                    value = childDocument.get(columnItems[i]);
                                }
                            }
                            if (value instanceof Date) {
                                record.put(StringUtils.substring(column, StringUtils.lastIndexOf(column, ".") + 1), DateFormatUtils.format((Date) value, "yyyy-MM-dd"));
                            } else {
                                record.put(StringUtils.substring(column, StringUtils.lastIndexOf(column, ".") + 1), value);
                            }
                        }
                    }
                }
            }
        }

//        if (StringUtils.isNotEmpty(remark)) {
//            SearchHistory searchHistory = new SearchHistory();
//            searchHistory.setThemeId(themeId);
//            searchHistory.setColumns(columns);
//            searchHistory.setConditions(conditions);
//            searchHistory.setSort(sort);
//            searchHistory.setLimit(limit);
//            searchHistory.setRemark(remark);
//            searchHistory.setCreatedUser(loginUser.getName());
//            searchHistoryMapper.insertOne(searchHistory);
//        }

        return recordList;
    }

    public Integer saveSearchHistory(Integer themeId, String columns, String conditions, String sort, Integer limit, String remark){
        if (StringUtils.isNotEmpty(remark)) {
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setThemeId(themeId);
            searchHistory.setColumns(columns);
            searchHistory.setConditions(conditions);
            searchHistory.setSort(sort);
            searchHistory.setLimit(limit);
            searchHistory.setRemark(remark);
            searchHistory.setCreatedUser(loginUser.getUsername());
            searchHistoryMapper.insertOne(searchHistory);
            Integer id = searchHistory.getId();
            return id;
        }
        return 0;
    }
}
