package com.cbx.sqlsession.proxy;

import com.cbx.cfg.Mapper;
import com.cbx.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
//    map的key是全限定类名加方法名 value是Mapper
    private Map<String,Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //用于对方法进行增强 其实就是调用selectList()方法
//    获取方法名
        String methodName=method.getName();
//        获取方法名所在类的名称
        String className = method.getDeclaringClass().getName();
//        组合key
        String key=className+"."+methodName;
//        获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        if(mapper==null){
            throw  new IllegalArgumentException("传入的参数有误");
        }
//        调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
