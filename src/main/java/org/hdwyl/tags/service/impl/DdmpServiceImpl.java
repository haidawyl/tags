package org.hdwyl.tags.service.impl;

import org.hdwyl.tags.service.BaseService;
import org.hdwyl.tags.service.DdmpService;
import org.apache.commons.lang3.StringUtils;
import org.hdwyl.tags.domain.*;
import org.hdwyl.tags.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DdmpServiceImpl extends BaseService implements DdmpService {

    @Autowired
    protected TagThemeMapper tagThemeMapper;

    @Autowired
    protected TagTypeMapper tagTypeMapper;

    @Autowired
    protected TagMappingMapper tagMappingMapper;

    @Autowired
    protected DictAreaMapper dictAreaMapper;

    @Autowired
    private DictCommonMapper dictCommonMapper;

    @Autowired
    protected DictMappingMapper dictMappingMapper;

    @Autowired
    protected DictIndustryMapper dictIndustryMapper;

    @Autowired
    protected ThemeColumnMapper themeColumnMapper;

    public List<TagTheme> getAllTagTheme() {
        return tagThemeMapper.queryAll();
    }

    public List<TagType> getAllTagType() {
        return tagTypeMapper.queryAll();
    }

    public List<TagMapping> getTagMappings(int themeId, int typeId) {
        return tagMappingMapper.query(themeId, typeId);
    }

    public List<?> getDict(String keyword, String[] args) {
        List<DictMapping> dictMappingList = dictMappingMapper.query(keyword);
        if (dictMappingList.size() == 1) {
            DictMapping dictMapping = dictMappingList.get(0);
            String condition = dictMapping.getCondition();
            condition = String.format(condition, args);
            if (StringUtils.equals(dictMapping.getTable(), "dict_area")) {
                List<DictArea> areaList = dictAreaMapper.queryDict(condition);
                return areaList;
            } else if (StringUtils.equals(dictMapping.getTable(), "dict_industry")) {
                List<DictIndustry> industryList = dictIndustryMapper.queryDict(condition);
                return industryList;
            } else {
                List<DictCommon> dictList = dictCommonMapper.queryDict(condition);
                return dictList;
            }
        }
        return null;
    }

    @Override
    public List<ThemeColumn> getDisplayColumns(Integer themeId, Integer status) {
        return themeColumnMapper.queryByTheme(themeId, status);
    }

}
