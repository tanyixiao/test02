package com.dao;

import com.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userDao {
    User userss();

    User Bypwd(User user);
    Integer add(@Param("name") String name,@Param("password") Integer password);
}
