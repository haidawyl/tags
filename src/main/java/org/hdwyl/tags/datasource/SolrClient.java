package org.hdwyl.tags.datasource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class SolrClient extends DataSourceConfig {

    protected static final Logger logger = LoggerFactory.getLogger(SolrClient.class);

    public static final int TIMEOUT = 30000;

    private ModifiableSolrParams params = null;

    public SolrClient(String host, int port, String username, String password, String schema) {
        super(host, port, username, password, schema);
    }

    private ModifiableSolrParams getModifiableSolrParams(){
        if(params == null){
            params = new ModifiableSolrParams();
            params.set(HttpClientUtil.PROP_MAX_CONNECTIONS, 128);
            params.set(HttpClientUtil.PROP_MAX_CONNECTIONS_PER_HOST, 32);
            params.set(HttpClientUtil.PROP_FOLLOW_REDIRECTS, false);
            params.set(HttpClientUtil.PROP_BASIC_AUTH_USER, super.username);
            params.set(HttpClientUtil.PROP_BASIC_AUTH_PASS, new String(Base64.decodeBase64(super.password.getBytes())));
            params.set(HttpClientUtil.PROP_MAX_CONNECTIONS, 1000);
            params.set(HttpClientUtil.PROP_ALLOW_COMPRESSION, true);
            params.set(HttpClientUtil.PROP_MAX_CONNECTIONS_PER_HOST, 1000);
        }
        return params;
    }

    private HttpSolrClient getCloseableHttpClient(ModifiableSolrParams params){
        String baseURL = String.format("http://%s:%s/solr/%s", super.host, super.port, super.schema);
        CloseableHttpClient closeableHttpClient = HttpClientUtil.createClient(params);
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(baseURL).withHttpClient(closeableHttpClient).build();
        httpSolrClient.setConnectionTimeout(SolrClient.TIMEOUT);
        httpSolrClient.setSoTimeout(SolrClient.TIMEOUT);
        httpSolrClient.setRequestWriter(new BinaryRequestWriter());
        return httpSolrClient;
    }

    public List<Map<String, Object>> query(String query, String filterQuery, String sort, String order, Integer start, Integer rows, String[] fields) {
        ModifiableSolrParams params = getModifiableSolrParams();

        HttpSolrClient httpSolrClient = getCloseableHttpClient(params);

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(query);
        if (StringUtils.isNotEmpty(filterQuery)) {
            solrQuery.setFilterQueries(filterQuery);
        }
        solrQuery.setSort(sort, SolrQuery.ORDER.valueOf(order));
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        if (fields != null && fields.length > 0) {
            solrQuery.setFields(fields);
        }

        try {
            QueryResponse queryResponse = httpSolrClient.query(solrQuery);
            long numFound = queryResponse.getResults().getNumFound();
            List<SolrDocument> documentList = queryResponse.getResults();
            List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
            for (SolrDocument document : documentList) {
                Map<String, Object> resultMap = new HashMap<String, Object>();
                Collection<String> fieldNames = document.getFieldNames();
                for (String fieldName : fieldNames) {
                    Object value = document.getFieldValue(fieldName);
                    if (value instanceof Date) {
                        resultMap.put(StringUtils.substring(fieldName, StringUtils.lastIndexOf(fieldName, ".") + 1), DateFormatUtils.format((Date) value, "yyyy-MM-dd"));
                    } else {
                        resultMap.put(StringUtils.substring(fieldName, StringUtils.lastIndexOf(fieldName, ".") + 1), value);
                    }
                }
                resultList.add(resultMap);
            }

            return resultList;
        } catch (SolrServerException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public List<FacetField> queryByFacet(String query, String[] facetFields) {
        ModifiableSolrParams params = getModifiableSolrParams();

        HttpSolrClient httpSolrClient = getCloseableHttpClient(params);
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(query);
        solrQuery.setFacet(true);//设置facet=on
        solrQuery.addFacetField(facetFields);
        solrQuery.setStart(0);
        solrQuery.setRows(0);
        try{
            QueryResponse response = httpSolrClient.query(solrQuery);
            List<FacetField> facets = response.getFacetFields();//返回的facet列表
            return facets;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return new ArrayList<FacetField>();
    }
}
