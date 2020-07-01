package com.cbx.dao;

import com.cbx.annotation.Select;
import com.cbx.pojo.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
