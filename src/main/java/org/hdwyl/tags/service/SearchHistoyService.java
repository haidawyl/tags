package org.hdwyl.tags.service;

import org.hdwyl.tags.domain.SearchHistory;

import java.util.List;
import java.util.Map;

public interface SearchHistoyService {

    List<SearchHistory> query(Map<String,Object> params);

    int getRowCount(Map<String,Object> params);

    List<SearchHistory> selConditions();

    void deleteSearchHistory(Integer id);

    int selHistoryCountByFav(Map<String, Object> params);
}
