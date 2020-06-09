package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.TagLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagLocationMapper {

    void insertOne(TagLocation instance);

    List<TagLocation> queryAll();

    TagLocation queryByPk(@Param("id") Integer id);
}
