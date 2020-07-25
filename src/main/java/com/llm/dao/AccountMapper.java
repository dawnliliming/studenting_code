package com.llm.dao;


import com.llm.pojo.Account;
import com.llm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    Account findAccount(@Param("aid")int id);

    //返回User和Account的联合查询
    List<Account> findUserAndAccount();

    User findUser(@Param("uid")int id);

}
