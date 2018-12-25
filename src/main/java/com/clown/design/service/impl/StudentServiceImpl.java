package com.clown.design.service.impl;

import com.clown.design.dao.IStudentDao;
import com.clown.design.entity.Student;
import com.clown.design.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    
    @Override
    public boolean updatePasswordById(Integer id,String password,String newPassword){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);
        map.put("password",password);
        map.put("newPassword",newPassword);
        int affectedRows =studentDao.updatePasswordById(map);
        boolean isUpdate=false;
        System.out.println(affectedRows);
        if(affectedRows==1){
            isUpdate=true;
        }
        return  isUpdate;
    }
    @Override
    public Student getStudentById(Integer id){
        return this.studentDao.selectStudentById(id);
    }

    @Override
    public Map<String, Object> listStudentByCurr(Integer page, Integer num) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        List<Student> list = this.studentDao.selectAllStudentByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.studentDao.selectCountStudent(null));
        return res;
    }

    @Override
    public Map<String, Object> listStudentByCurr(Integer page, Integer num, Integer classId) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        req.put("classId", classId);
        List<Student> list = this.studentDao.selectAllStudentByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.studentDao.selectCountStudent(classId));
        return res;
    }

    @Override
    public Integer addStudent(Student student) {
        return this.studentDao.insertStudent(student);
    }

    @Override
    public Integer updateStudent(Student student) {
        return this.studentDao.updateStudent(student);
    }

    @Override
    public Integer delStudentById(Integer id) {
        return this.studentDao.deleteStudentById(id);
    }

    @Override
    public Student verifyStudent(String studentName, String password) {
        return this.studentDao.selectStudentByStudentNameAndPassword(studentName, password);
    }

    @Override
    public Integer setTopicIdById(Integer topicId, Integer id) {
        return this.studentDao.updateStudentInTopicIdById(topicId, id);
    }


}
