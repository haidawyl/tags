package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.TagType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagTypeMapper {

    void insertOne(TagType instance);

    List<TagType> queryAll();
}
