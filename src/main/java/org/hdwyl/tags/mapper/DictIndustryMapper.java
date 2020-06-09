package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.DictIndustry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictIndustryMapper {

    List<DictIndustry> queryDict(@Param("condition") String condition);

    DictIndustry queryByPk(@Param("trid") String trid);

    List<DictIndustry> queryDictAndParent();
}
