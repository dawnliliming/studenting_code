package com.llm.dao;


import com.llm.pojo.Account;
import com.llm.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    User findUserById(int id);

    List<User> findUserListByLimit(Map<String,Object> map);


    @Insert("insert into user (id,username,birthday) values (#{id},#{name},#{birth})")
    void insertById(@Param("id")int id,@Param("name")String name,@Param("birth")Date birth);

    //返回User和Account的联合查询
    List<Account> findUserAndAccount();

}
