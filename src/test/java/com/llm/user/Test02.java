package com.llm.user;

import com.llm.dao.AccountMapper;
import com.llm.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class Test02 {

    @org.junit.Test
    public void test1() throws IOException {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = factory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        List<Account> userAndAccount = accountMapper.findUserAndAccount();

        for (Account user : userAndAccount){
            System.out.println(user);
        }
    }
}
