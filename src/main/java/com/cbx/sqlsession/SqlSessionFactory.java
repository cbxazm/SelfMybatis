package com.cbx.sqlsession;

import java.sql.SQLException;

public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession() throws SQLException, ClassNotFoundException;
}
