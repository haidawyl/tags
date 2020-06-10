package org.hdwyl.tags.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hdwyl.tags.domain.User;

@Mapper
public interface UserMapper {

    User queryByUsername(@Param("username") String username);

}
