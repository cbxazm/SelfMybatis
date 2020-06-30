package com.cbx.cfg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于封装执行的sql语句和结果类型的全限定类名
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mapper {
    private String queryString; //sql语句
    private String resultType;  //实体类的全限定类名

}
