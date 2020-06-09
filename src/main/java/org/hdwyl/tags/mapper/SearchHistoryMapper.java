package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.SearchHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchHistoryMapper {

    void insertOne(SearchHistory searchHistory);

    List<SearchHistory> query(Map<String, Object> params);

    int getRowCount(Map<String, Object> params);

    List<SearchHistory> selConditions();

    void deleteSearchHistory(Integer id);

    int selHistoryCountByFav(Map<String, Object> params);
}
