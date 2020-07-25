package com.llm.dao;


import com.llm.pojo.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findRolesByUser();

}
