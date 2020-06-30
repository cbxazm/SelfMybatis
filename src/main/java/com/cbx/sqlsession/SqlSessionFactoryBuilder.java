package com.cbx.sqlsession;

import com.cbx.cfg.Configuration;
import com.cbx.sqlsession.defaults.DefaultSqlSessionFactory;
import com.cbx.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建sqlsessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) {
        Configuration cfg= XMLConfigBuilder.loadConfiguration(inputStream);
              return new DefaultSqlSessionFactory(cfg);
    }
}
