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

    @RequestMapping("/listStudentByCurr")
    public Map<String, Object> listStudentByCurr(HttpServletResponse response, HttpServletRequest request, Student student) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String page = request.getParameter("page");
        String num = request.getParameter("num");
        String _classId = request.getParameter("classId");
        if(page.equals("")) {
            res.put("message", "page不能为空！");
        } else if(num.equals("")) {
            res.put("message", "num不能为空！");
        } else {
            Map<String, Object> map;
            if(_classId==null||_classId.equals("")) {
                map = this.studentService.listStudentByCurr(Integer.parseInt(page), Integer.parseInt(num));
            } else {
                map = this.studentService.listStudentByCurr(Integer.parseInt(page), Integer.parseInt(num), Integer.parseInt(_classId));
            }
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

    @RequestMapping("/addStudent")
    public Map<String, Object> addStudent(HttpServletResponse response, HttpServletRequest request, Student student) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String studentName = student.getStudentName();
        String studentIdentifier = student.getStudentIdentifier();
        Integer collegeId = student.getCollegeId();
        Integer classId = student.getClassId();
        String password = student.getPassword();
        if(studentName==null||studentName.equals("")){
            res.put("message", "studentName不能为空！");
        } else if(studentIdentifier==null||studentIdentifier.equals("")) {
            res.put("message", "studentIdentifier不能为空！");
        } else if(collegeId==null||collegeId.equals("")) {
            res.put("message", "collegeId不能为空！");
        } else if(classId==null||classId.equals("")) {
            res.put("message", "classId不能为空！");
        } else if(password==null||password.equals("")){
            res.put("message", "password不能为空！");
        } else if(this.studentService.addStudent(student) != -1){
            res.put("isSuccessful", true);
            res.put("message", "添加成功！");
        } else {
            res.put("message", "添加失败！");
        }
        return res;
    }

    @RequestMapping("/updateStudent")
    public Map<String, Object> updateStudent(HttpServletResponse response, HttpServletRequest request, Student student) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = student.getClassId();
        String studentName = student.getStudentName();
        String studentIdentifier = student.getStudentIdentifier();
        Integer collegeId = student.getCollegeId();
        Integer classId = student.getClassId();
        String password = student.getPassword();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        } else if(studentName==null||studentName.equals("")){
            res.put("message", "studentName不能为空！");
        } else if(studentIdentifier==null||studentIdentifier.equals("")) {
            res.put("message", "studentIdentifier不能为空！");
        } else if(collegeId==null||collegeId.equals("")) {
            res.put("message", "collegeId不能为空！");
        } else if(classId==null||classId.equals("")) {
            res.put("message", "classId不能为空！");
        } else if(password==null||password.equals("")){
            res.put("message", "password不能为空！");
        } else if(this.studentService.updateStudent(student) != -1){
            res.put("isSuccessful", true);
            res.put("message", "修改成功！");
        } else {
            res.put("message", "修改失败！");
        }
        return res;
    }

    @RequestMapping("/delStudentById")
    public Map<String, Object> delStudentById(HttpServletResponse response, HttpServletRequest request, Student student) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = student.getId();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        } else if(this.studentService.delStudentById(id) != -1) {
            res.put("isSuccessful", true);
            res.put("message", "删除成功！");
        } else {
            res.put("message", "删除失败！");
        }
        return res;
    }

    @RequestMapping(value = "verifyStudent", method = RequestMethod.POST)
    public Map<String, Object> verifyStudent(HttpServletRequest request, HttpServletResponse response, Student student) throws  IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccessful", false);
        String studentIdentifier = student.getStudentIdentifier();
        String password = student.getPassword();
        if(studentIdentifier==null||studentIdentifier.equals("")) {
            map.put("message", "studentName不能为空！");
        } else if(password==null||password.equals("")) {
            map.put("message", "password不能为空！");
        } else{
            Student res = this.studentService.verifyStudent(studentIdentifier, password);
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

    @RequestMapping("/setTopicIdById")
    public Map<String, Object> setTopicIdById(HttpServletResponse response, HttpServletRequest request, Student student) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = student.getId();
        Integer topicId = student.getTopicId();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        } else if(topicId==null||topicId.equals("")) {
            res.put("message", "topicId不能为空！");
        } else if(this.studentService.setTopicIdById(topicId, id) != -1) {
            res.put("isSuccessful", true);
            res.put("message", "设置成功！");
        } else {
            res.put("message", "设置失败！");
        }
        return res;
    }
    
}
