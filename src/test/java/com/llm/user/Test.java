package com.llm.user;

import com.llm.dao.UserMapper;
import com.llm.pojo.User;
import com.llm.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

    @org.junit.Test
    public void test1() throws IOException {

        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();


        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.findUserById(42);
        System.out.println(userById.hashCode()); //936580213
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User userById2 = mapper2.findUserById(42);
        System.out.println(userById.hashCode()); //936580213
        sqlSession2.close();

        System.out.println(userById == userById2); //false

    }

    @org.junit.Test
    public void test2() throws IOException {

        Logger.getLogger(Test.class);

    }

    //模糊查询
    @org.junit.Test
    public void test3() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //使用Map来传参，公司里都这么用
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("startIndex",0);
        map.put("pageSize",2);


        List<User> userListByLimit = mapper.findUserListByLimit(map);

        for (User user : userListByLimit){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @org.junit.Test
    public void test4() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.insertById(20, "刘邦", new Date());

        //做更新操作一定要提交事务，要不然的话会进行回滚
        sqlSession.commit();

        sqlSession.close();
    }

}
