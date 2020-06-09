package org.hdwyl.tags.controller;

import com.alibaba.fastjson.JSONObject;
import org.hdwyl.tags.domain.SearchHistory;
import org.hdwyl.tags.service.SearchHistoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchHistoryController {

    @Autowired
    protected SearchHistoyService searchHistoyService;

    @RequestMapping(value = "/searchHistory")
    public String searchHistory(HttpServletRequest request, Model model,String value) {
        List<SearchHistory> conditions = searchHistoyService.selConditions();
        model.addAttribute("value",value);
        model.addAttribute("conditions",conditions);
        return "searchHistory";
    }

    @RequestMapping(value = "/getSearchHistory")
    @ResponseBody
    public JSONObject getSearchHistory(HttpServletRequest request, int limit, int offset) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("offset",(offset/10)*limit);
        params.put("size",limit);
        List<SearchHistory> shs = searchHistoyService.query(params);
        JSONObject json = new JSONObject();
        json.put("rows", shs);
        int total = searchHistoyService.getRowCount(params);
        json.put("total", total);

        return json;
    }

    @RequestMapping(value = "/deleteSearchHistory")
    @ResponseBody
    public String deleteSearchHistory(Integer id) {
        searchHistoyService.deleteSearchHistory(id);
        return "success";
    }
}
