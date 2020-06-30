package com.cbx.utils;

import com.cbx.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {
    /**
     * 用于获取一个数据库连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) throws SQLException, ClassNotFoundException {
        Class.forName(cfg.getDriver());
        Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        return connection;
    }
}
