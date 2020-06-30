package com.cbx.sqlsession.defaults;

import com.cbx.cfg.Configuration;
import com.cbx.sqlsession.SqlSession;
import com.cbx.sqlsession.proxy.MapperProxy;
import com.cbx.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的实现类
 */
public class DefaultSqlSession implements SqlSession{
    private Configuration cfg;
    private Connection conn;
    public DefaultSqlSession(Configuration cfg) throws SQLException, ClassNotFoundException {
        this.cfg=cfg;
        conn= DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass  dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn)
                );

    }

    /**
     * 用于释放资源的
     */
    public void close() {
        if (conn!=null){
            try {

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
