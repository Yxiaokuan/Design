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
        map.put("data", this.roleSerivce.getRoleById(role.getId()));
        return map;
    }
}
