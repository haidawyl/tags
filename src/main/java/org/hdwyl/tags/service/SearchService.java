package org.hdwyl.tags.service;

import java.util.List;
import java.util.Map;

public interface SearchService {

    List<?> search(Integer themeId, String columns, String conditions, String sort, Integer limit, String remark);

    List<Map<String, Object>> getColumns(Integer themeId, String[] columns);

    List<Map<String, Object>> getColumns(Integer themeId, Integer status);

    Integer saveSearchHistory(Integer themeId, String columns, String conditions, String sort, Integer limit, String remark);
}
