package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.TagTheme;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagThemeMapper {

    void insertOne(TagTheme instance);

    List<TagTheme> queryAll();
}
