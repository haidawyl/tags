package org.hdwyl.tags.controller;

import com.alibaba.fastjson.JSONObject;
import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.domain.CityIndustryCount;
import org.hdwyl.tags.service.CityIndustryCountService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.FacetField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class CityIndustryCountController {

    @Autowired
    protected CityIndustryCountService cityIndustryCountService;

    @RequestMapping(value = "/cicount")
    public String getProvinces(Model model) {
        Integer themeId = 1;
        String columns = cityIndustryCountService.getDefaultColumns(themeId, Constants.Status.VALID.getValue());
        model.addAttribute("columns", columns);
        return "cityIndustryCount";
    }

    @RequestMapping(value = "/getCityIndustryL2Count")
    @ResponseBody
    public JSONObject getCityIndustryL2Count(String province, String provinceCode, String city, String cityCode) throws IOException, SolrServerException {
        city = city.replaceAll("\n", "").trim();
        List<CityIndustryCount> cityIndustryCounts = cityIndustryCountService.queryByFacet("background.baseInfo.city:" + city, new String[]{"background.baseInfo.industryL2"}, province, city, provinceCode, cityCode);
        JSONObject json = new JSONObject();
        json.put("rows", cityIndustryCounts);
        json.put("total", cityIndustryCounts.size());
        return json;
    }
}