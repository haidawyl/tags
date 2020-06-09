package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.TagMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMappingMapper {

    void insertOne(TagMapping instance);

    List<TagMapping> queryAll();

    List<TagMapping> query(@Param("themeId") Integer themeId, @Param("typeId") Integer typeId);

    TagMapping queryByLocation(@Param("locationId") Integer locationId);
}
