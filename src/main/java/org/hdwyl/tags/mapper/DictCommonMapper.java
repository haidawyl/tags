package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.DictCommon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictCommonMapper {

    List<DictCommon> queryDict(@Param("condition") String condition);

    DictCommon query(@Param("category") String category, @Param("code") Integer code);
}
