package com.clown.design.dao;

import com.clown.design.entity.Role;

import java.util.Map;

public interface IRoleDao {
    Role selectRoleById(Integer id);
    Role selectRoleByPassWord(Map<String, Object> map);
}
