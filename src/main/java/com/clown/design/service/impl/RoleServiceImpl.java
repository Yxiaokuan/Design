package com.clown.design.service.impl;

import com.clown.design.dao.IRoleDao;
import com.clown.design.entity.Role;
import com.clown.design.service.IRoleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleSerivce {
    @Autowired
    private IRoleDao roleDao;


    @Override
    public Role getRoleById(Integer id) {
        return this.roleDao.selectRoleById(id);
    }

    @Override
    public Role verifyRole(String roleName, String passWord) {
        Map<String, Object> req = new HashMap<>();
        req.put("roleName", roleName);
        req.put("passWord", passWord);
        return this.roleDao.selectRoleByPassWord(req);
    }
}
