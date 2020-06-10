package org.hdwyl.tags.service.impl;

import org.hdwyl.tags.domain.SearchHistory;
import org.hdwyl.tags.mapper.SearchHistoryMapper;
import org.hdwyl.tags.model.InsuserModel;
import org.hdwyl.tags.service.BaseService;
import org.hdwyl.tags.service.SearchHistoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchHistoryServiceImpl extends BaseService implements SearchHistoyService {

    @Autowired
    protected SearchHistoryMapper searchHistoryMapper;

    @Override
    public List<SearchHistory> query(Map<String, Object> params) {
        InsuserModel model = getLoginUser();
        params.put("username",model.getUsername());
        List<SearchHistory> searchHistories = searchHistoryMapper.query(params);
        for(SearchHistory searchHistory : searchHistories){
            int isDelete = searchHistory.getIsDelete();
            if(isDelete == 0 && model.getUsername().equals(searchHistory.getCreatedUser())){
                searchHistory.setIsDelete(0);
            }else{
                searchHistory.setIsDelete(1);
            }
        }
        return searchHistories;
    }

    @Override
    public int getRowCount(Map<String, Object> params) {
        return searchHistoryMapper.getRowCount(params);
    }

    @Override
    public List<SearchHistory> selConditions() {
        return searchHistoryMapper.selConditions();
    }

    @Override
    public void deleteSearchHistory(Integer id){
        searchHistoryMapper.deleteSearchHistory(id);
    }

    @Override
    public int selHistoryCountByFav(Map<String, Object> params){
        InsuserModel model = getLoginUser();
        params.put("username",model.getUsername());
        return searchHistoryMapper.selHistoryCountByFav(params);
    }

}
