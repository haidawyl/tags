package org.hdwyl.tags.service;

import org.hdwyl.tags.domain.TagMapping;
import org.hdwyl.tags.domain.TagTheme;
import org.hdwyl.tags.domain.TagType;
import org.hdwyl.tags.domain.ThemeColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagsService {

    List<TagTheme> getAllTagTheme();

    List<TagType> getAllTagType();

    List<TagMapping> getTagMappings(int themeId, int typeId);

    List<?> getDict(String keyword, String[] args);

    /**
     * 获取显示列
     *
     * @param themeId 主题ID
     * @param status 状态
     * @return
     */
    List<ThemeColumn> getDisplayColumns(Integer themeId, Integer status);
}
