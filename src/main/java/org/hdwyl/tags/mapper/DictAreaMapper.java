package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.DictArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictAreaMapper {

    List<DictArea> queryDict(@Param("condition") String condition);

    DictArea queryByPk(@Param("areaCode") String areaCode);
}
