package org.hdwyl.tags.service.impl;

import org.hdwyl.tags.domain.DictCommon;
import org.hdwyl.tags.domain.Favorites;
import org.hdwyl.tags.mapper.DictCommonMapper;
import org.hdwyl.tags.mapper.FavoritesMapper;
import org.hdwyl.tags.model.InsuserModel;
import org.hdwyl.tags.service.BaseService;
import org.hdwyl.tags.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FavoritesServiceImpl extends BaseService implements FavoritesService {

    @Autowired
    protected FavoritesMapper favoritesMapper;

    @Autowired
    protected DictCommonMapper dictCommonMapper;

    public void insertOne(Favorites favorites) {
        InsuserModel model = getLoginUser();
        favorites.setUsername(model.getUsername());
        DictCommon dictCommon = dictCommonMapper.query("myFavorites", 1);
        favorites.setCategory(dictCommon.getId());
        favoritesMapper.insertOne(favorites);
    }

    public List<Favorites> selFavorites(Map<String, Object> params) {
        InsuserModel model = getLoginUser();
        params.put("username", model.getUsername());
        return favoritesMapper.selFavorites(params);
    }

    public int getRowCount(Map<String, Object> params) {
        InsuserModel model = getLoginUser();
        params.put("username", model.getUsername());
        return favoritesMapper.getRowCount(params);
    }

    public void deleteFavorites(Map<String, Object> params) {
        InsuserModel model = getLoginUser();
        params.put("username", model.getUsername());
        favoritesMapper.deleteFavorites(params);
    }
}
