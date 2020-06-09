package org.hdwyl.tags.controller;

import com.alibaba.fastjson.JSONObject;
import org.hdwyl.tags.domain.Favorites;
import org.hdwyl.tags.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FavoritesController {

    @Autowired
    protected FavoritesService favoritesService;

    @RequestMapping(value = "/searchFavorites")
    public String searchHistory() {
        return "favorites";
    }

    @RequestMapping(value = "/getFavorites")
    @ResponseBody
    public JSONObject getFavorites(int limit, int offset) {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Favorites> favorites = favoritesService.selFavorites(params);
        params.put("offset", (offset / 10) * limit);
        params.put("size", limit);
        JSONObject json = new JSONObject();
        json.put("rows", favorites);
        Map<String, Object> countParams = new HashMap<String, Object>();
        int total = favoritesService.getRowCount(countParams);
        json.put("total", total);
        return json;
    }

    @RequestMapping(value = "/saveFavorites")
    @ResponseBody
    public String saveFavorites(Favorites favorites) {
        favoritesService.insertOne(favorites);
        return "success";
    }

    @RequestMapping(value = "/deleteFavorites")
    @ResponseBody
    public String deleteFavorites(Integer id){
        Map<String,Object> params = new HashMap<>();
        params.put("favId",id);
        favoritesService.deleteFavorites(params);
        return "success";
    }
}
