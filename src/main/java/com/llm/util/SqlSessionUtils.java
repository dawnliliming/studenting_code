package com.llm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtils {

    public static SqlSessionFactory getSqlSessionFactory() {

        SqlSessionFactory factory = null;
        try {
            if (factory == null){
                factory =  new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory;
    }


    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }

}
