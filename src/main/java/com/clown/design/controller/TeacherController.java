package com.clown.design.controller;

import com.clown.design.entity.Teacher;
import com.clown.design.service.ITeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {
    
    @Autowired
    private ITeacherService teacherService;
    
    @RequestMapping(value = "/getTeacherById", method = RequestMethod.GET)
    public Map<String, Object> getTeacherById(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String id = req.getParameter("id");
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccessful", false);
        if (id == null || id.equals("")) {
            map.put("message", "id不能空！");
        } else {
            Teacher result = this.teacherService.getTeacherById(Integer.parseInt(id));
            if (result != null) {
                map.put("isSuccessful", true);
                map.put("data", result);
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
        Teacher result = this.teacherService.getTeacherById(Integer.parseInt(id));
        map.put("isSuccessful", false);
        if (id == null || id.equals("")) {
            map.put("message", "id不能为空！");
        }else if(password == null || password.equals("")){
            map.put("message", "密码不能为空！");
        }else if(newPassword == null || newPassword.equals("")){
            map.put("message", "新密码不能为空！");
        }else if(result== null){
            map.put("message", "用户不存在！");
        }else {
            Boolean  isUpdate= this.teacherService.updatePasswordById(Integer.parseInt(id),password,newPassword);
            if (isUpdate) {
                map.put("isSuccessful", true);
                map.put("message", "信息修改成功");
            } else {
                map.put("message", "信息修改失败！");
            }
        }
        return map;
    }

    @RequestMapping("/listTeacherByCurr")
    public Map<String, Object> listTeacherByCurr(HttpServletResponse response, HttpServletRequest request, Teacher teacher) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String page = request.getParameter("page");
        String num = request.getParameter("num");
        if(page.equals("")) {
            res.put("message", "page不能为空！");
        } else if(num.equals("")) {
            res.put("message", "num不能为空！");
        } else {
            Map<String, Object> map = this.teacherService.listTeacherByCurr(Integer.parseInt(page), Integer.parseInt(num));
            if(map != null) {
                res.put("isSuccessful", true);
                res.put("list", map.get("list"));
                res.put("count", map.get("size"));
                res.put("total", map.get("total"));
            } else {
                res.put("message", "查询失败！");
            }
        }
        return res;
    }

    @RequestMapping("/addTeacher")
    public Map<String, Object> addTeacher(HttpServletResponse response, HttpServletRequest request, Teacher teacher) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String teacherName = teacher.getTeacherName();
        String password = teacher.getPassword();
        String jobNumber = teacher.getJobNumber();
        if(teacherName==null||teacherName.equals("")) {
            res.put("message", "teacherName不能为空！");
        } else if(jobNumber==null||jobNumber.equals("")) {
            res.put("message", "jobNumber不能为空！");
        } else if(password==null||password.equals("")) {
            res.put("message", "passWord不能为空！");
        } else if(this.teacherService.addTeacher(teacher) != -1) {
            res.put("isSuccessful", true);
            res.put("message", "添加成功！");
        } else {
            res.put("message", "添加失败！");
        }
        return res;
    }

    @RequestMapping("/updateTeacher")
    public Map<String, Object> updateTeacher(HttpServletResponse response, HttpServletRequest request, Teacher teacher) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = teacher.getId();
        String teacherName = teacher.getTeacherName();
        String password = teacher.getPassword();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        }
        if(teacherName==null||teacherName.equals("")) {
            res.put("message", "teacherName不能为空！");
        } else if(password==null||password.equals("")) {
            res.put("message", "passWord不能为空！");
        } else if(this.teacherService.updateTeacher(teacher) != -1) {
            res.put("isSuccessful", true);
            res.put("message", "修改成功！");
        } else {
            res.put("message", "修改失败！");
        }
        return res;
    }

    @RequestMapping("/delTeacherById")
    public Map<String, Object> delTeacherById(HttpServletResponse response, HttpServletRequest request, Teacher teacher) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = teacher.getId();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        } else if(this.teacherService.delTeacherById(id) != -1) {
            res.put("isSuccessful", true);
            res.put("message", "删除成功！");
        } else {
            res.put("message", "删除失败！");
        }
        return res;
    }

    @RequestMapping(value = "verifyTeacher", method = RequestMethod.POST)
    public Map<String, Object> verifyTeacher(HttpServletRequest request, HttpServletResponse response, Teacher teacher) throws  IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccessful", false);
        String jobNumber = teacher.getJobNumber();
        String password = teacher.getPassword();
        if(jobNumber==null||jobNumber.equals("")) {
            map.put("message", "jobNumber不能为空！");
        } else if(password==null||password.equals("")) {
            map.put("message", "password不能为空！");
        } else{
            Teacher res = this.teacherService.verifyTeacher(jobNumber, password);
            if(res != null) {
                map.put("isSuccessful", true);
                map.put("message", "登录成功！");
                map.put("id", res.getId());
            } else {
                map.put("message", "登录失败！");
            }
        }
        return map;
    }

}
