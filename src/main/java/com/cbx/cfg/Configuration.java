package com.cbx.cfg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义mybatis的配置类
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Configuration {
     private String driver;
     private String url;
     private String username;
     private String password;
     private Map<String,Mapper> mappers=new HashMap<String, Mapper>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
//        这里不能直接让它一直覆盖，必须追加
//        this.mappers = mappers;
        this.mappers.putAll(mappers);
    }
}
