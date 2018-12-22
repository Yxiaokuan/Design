package com.clown.design.controller;

import com.clown.design.entity.Role;
import com.clown.design.service.IRoleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleSerivce roleSerivce;

    @RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
    public Map<String, Object> getRoleById(HttpServletRequest request, HttpServletResponse response, Role role) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccessful", false);
        Integer id = role.getId();
        if(id==null||id.equals("")) {
            map.put("message", "id不能为空！");
        }else{
            Role res = this.roleSerivce.getRoleById(id);
            if(res != null) {
                map.put("isSuccessful", true);
                map.put("data", res);
            } else {
                map.put("message", "登录失败！");
            }
        }
        return map;
    }

    @RequestMapping(value = "verifyRole", method = RequestMethod.POST)
    public Map<String, Object> verifyRole(HttpServletRequest request, HttpServletResponse response, Role role) throws  IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccessful", false);
        String roleName = role.getRoleName();
        String password = role.getPassword();
        if(roleName==null||roleName.equals("")) {
            map.put("message", "roleName不能为空！");
        } else if(password==null||password.equals("")) {
            map.put("message", "password不能为空！");
        } else{
            Role res = this.roleSerivce.verifyRole(roleName, password);
            if(res != null) {
                map.put("isSuccessful", true);
                map.put("message", "登录成功！");
                map.put("roleId", res.getId());
                map.put("roleType", res.getRoleType());
            } else {
                map.put("message", "登录失败！");
            }
        }
        return map;
    }
}
