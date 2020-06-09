package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.Favorites;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FavoritesMapper {

    void insertOne(Favorites favorites);

    List<Favorites> selFavorites(Map<String,Object> params);

    int getRowCount(Map<String,Object> params);

    void deleteFavorites(Map<String,Object> params);
}
