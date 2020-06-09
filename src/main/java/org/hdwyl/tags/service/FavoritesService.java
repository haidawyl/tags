package org.hdwyl.tags.service;

import org.hdwyl.tags.domain.Favorites;

import java.util.List;
import java.util.Map;

public interface FavoritesService {

    void insertOne(Favorites favorites);

    List<Favorites> selFavorites(Map<String,Object> params);

    int getRowCount(Map<String,Object> params);

    void deleteFavorites(Map<String,Object> params);
}
