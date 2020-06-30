package com.cbx.sqlsession.defaults;

import com.cbx.cfg.Configuration;
import com.cbx.sqlsession.SqlSession;
import com.cbx.sqlsession.SqlSessionFactory;

import java.sql.SQLException;

/**
 * SqlSessionFactory的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /**
     * 用于创建一个新的操作数据库的对象
     * @return
     */
    public SqlSession openSession() throws SQLException, ClassNotFoundException {


            return new DefaultSqlSession(cfg);

    }
}
