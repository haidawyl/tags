package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataSourceMapper {

    void insertOne(DataSource instance);

    List<DataSource> queryAll();

    DataSource queryByPk(@Param("id") Integer id);
}
