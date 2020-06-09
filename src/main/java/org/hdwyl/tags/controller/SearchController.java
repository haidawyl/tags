package org.hdwyl.tags.controller;

import com.alibaba.fastjson.JSONObject;
import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.common.Config;
import org.hdwyl.tags.service.SearchHistoyService;
import org.hdwyl.tags.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    protected SearchService searchService;

    @Autowired
    protected SearchHistoyService searchHistoyService;
    /**
     * 系统常量
     */
    @Autowired
    private Config config;

    @RequestMapping("/search")
    String search(HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap) {
        if (StringUtils.isNotEmpty(request.getParameter("themeId"))) {
            Integer themeId = Integer.parseInt(request.getParameter("themeId"));
            String columns = request.getParameter("columns");
            String conditions = request.getParameter("conditions");
            String sort = request.getParameter("sort");
            Integer limit = Integer.parseInt(request.getParameter("limit"));
            String remark = request.getParameter("remark");
            Integer id = null;
            if (StringUtils.isNotEmpty(request.getParameter("id"))) {
                id = Integer.parseInt(request.getParameter("id"));
                resultMap.put("id", id);
            }else{
                id = searchService.saveSearchHistory(themeId, columns, conditions, sort, limit, remark);
                resultMap.put("id", id);
            }

            List<Map<String, Object>> columnList = null;
            if (StringUtils.split(columns, ",").length > 1) {
                resultMap.put("customColumns", columns);
                columnList = searchService.getColumns(themeId, StringUtils.split(columns, ","));
            } else {
                resultMap.put("customColumns", "");
                columnList = searchService.getColumns(themeId, Constants.Status.VALID.getValue());
            }
            resultMap.put("themeId", themeId);
            resultMap.put("tableColumns", columnList);
            resultMap.put("conditions", conditions);
            resultMap.put("sort", sort);
            resultMap.put("limit", limit);
            resultMap.put("remark", remark);

            Map<String, Object> params = new HashMap<>();
            params.put("id",id);
            int fav = searchHistoyService.selHistoryCountByFav(params);
            //fav: 0：可以收藏 1：已收藏
            resultMap.put("fav", fav);
        }
        return "searchResults";
    }

    @RequestMapping("/search/getResults")
    @ResponseBody
    JSONObject getResults(HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap) {
        Integer themeId = Integer.parseInt(request.getParameter("themeId"));
        String columns = request.getParameter("columns");
        String conditions = request.getParameter("conditions");
        String sort = request.getParameter("sort");
        Integer limit = Integer.parseInt(request.getParameter("limit"));
        String remark = null;
        if (StringUtils.isEmpty(request.getParameter("id"))) {
            remark = request.getParameter("remark");
        }
        List<?> resultList = searchService.search(themeId, columns, conditions, sort, limit, remark);
        JSONObject json = new JSONObject();
        json.put("rows", resultList);
        json.put("total", resultList.size());

        return json;
    }

    @RequestMapping(value = "/downloadpdf")
    public void downloadpdf(HttpServletResponse response, String id) {
        OutputStream out = null;
        try {
            byte[] rByte = loadPdf(config.getPdfUrl(), id);
            response.setHeader("Content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String((id + ".pdf").getBytes("UTF-8"), "ISO_8859_1"));
            response.setHeader("Connection", "keep-alive");
            out = response.getOutputStream();
            out.write(rByte);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 生成PDFJsoup请求
     */
    public static byte[] loadPdf(String url, String id) throws Exception {
        Connection.Response response = Jsoup.connect(url + "standard_report")
                .data("id", id)
                .data("token", "26gvwmNAJLhuYeP1KRJHmVjNwhQrZ/Vm")
                .ignoreContentType(true)
                .timeout(10 * 1000000)
                .maxBodySize(0)
                .execute();
        return response.bodyAsBytes();
    }
}
