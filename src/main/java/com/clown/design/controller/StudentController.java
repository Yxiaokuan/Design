package com.clown.design.controller;

import com.clown.design.entity.Student;
import com.clown.design.service.IStudentService;
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
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private IStudentService studentService;
    
    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    public Map<String, Object> getStudentById(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String id = req.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccessful", false);
        if (id == null || id.equals("")) {
            map.put("message", "id不能为空！");
        } else {
            Student stu = this.studentService.getStudentById(Integer.parseInt(id));
            if (stu != null) {
                map.put("isSuccessful", true);
                map.put("data", stu);
            } else {
                map.put("message", "用户不存在！");
            }
        }
        return map;
    }
    
    @RequestMapping(value = "/updatePasswordById", method = RequestMethod.GET)
    public Map<String, Object> updatePasswordById(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");
        Map<String, Object> map = new HashMap<>();
        Student stu = this.studentService.getStudentById(Integer.parseInt(id));
        map.put("isSuccessful", false);
        if (id == null || id.equals("")) {
            map.put("message", "id不能为空！");
        }else if(password == null || password.equals("")){
            map.put("message", "密码不能为空！");
        }else if(newPassword == null || newPassword.equals("")){
            map.put("message", "新密码不能为空！");
        }else if(stu== null){
            map.put("message", "用户不存在！");
        }else {
            Boolean  isUpdate= this.studentService.updatePasswordById(Integer.parseInt(id),password,newPassword);
            if (isUpdate) {
                map.put("isSuccessful", true);
                map.put("message", "信息修改成功");
            } else {
                map.put("message", "信息修改失败！");
            }
        }
        return map;
    }
    
}
