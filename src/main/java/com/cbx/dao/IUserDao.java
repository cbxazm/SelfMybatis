package com.cbx.dao;

import com.cbx.pojo.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
