package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.DictMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictMappingMapper {

    List<DictMapping> query(@Param("keyword") String keyword);
}
