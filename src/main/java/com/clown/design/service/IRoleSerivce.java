package com.clown.design.service;

import com.clown.design.entity.Role;

public interface IRoleSerivce {
    Role getRoleById(Integer id);
    Role verifyRole(String roleName, String passWord);
}
