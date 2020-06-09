package org.hdwyl.tags.mapper;

import org.hdwyl.tags.domain.ThemeColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ThemeColumnMapper {

    ThemeColumn queryByPk(@Param("themeId") Integer themeId, @Param("column") String column);

    List<ThemeColumn> queryByTheme(@Param("themeId") Integer themeId, @Param("status") Integer status);

    List<ThemeColumn> queryDefaultByTheme(@Param("themeId") Integer themeId, @Param("status") Integer status);
}
