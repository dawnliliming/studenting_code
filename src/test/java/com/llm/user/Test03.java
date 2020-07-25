package com.llm.user;

import com.llm.dao.RoleMapper;
import com.llm.pojo.Role;
import com.llm.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test03 {

    @org.junit.Test
    public void test01(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> rolesByUser = mapper.findRolesByUser();
        for (Role role : rolesByUser){
            System.out.println(role);
        }
        sqlSession.close();
    }

}
