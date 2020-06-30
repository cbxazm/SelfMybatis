package com.cbx;


import com.cbx.dao.IUserDao;
import com.cbx.mybatis.io.Resources;
import com.cbx.pojo.User;
import com.cbx.sqlsession.SqlSession;
import com.cbx.sqlsession.SqlSessionFactory;
import com.cbx.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class mybatistest {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//        读取配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlsessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(inputStream);
//        创建sqlsession对象
        SqlSession sqlSession = sessionFactory.openSession();
//        使用动态代理创建代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
//        如果使用自定义的实现类处理
//        IUserDaoImpl iUserDao=new IUserDaoImpl(sessionFactory);
//        List<User> all1 = iUserDao.findAll();
        List<User> all = mapper.findAll();
        System.out.println(all);
        sqlSession.close();
//        System.out.println(all);
        inputStream.close();
    }
}
