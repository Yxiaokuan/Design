package com.clown.design.service.impl;

import com.clown.design.dao.ITeacherDao;
import com.clown.design.entity.Teacher;
import com.clown.design.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements ITeacherService {
    private Teacher teacher ;
    @Autowired
    private ITeacherDao teacherDao;
    
    @Override
    public boolean updatePasswordById(Integer id,String password,String newPassword){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);
        map.put("password",password);
        map.put("newPassword",newPassword);
        int affectedRows =teacherDao.updatePasswordById(map);
        boolean isUpdate=false;
        if(affectedRows==1){
            isUpdate=true;
        }
        return  isUpdate;
    }
    
    @Override
    public Teacher getTeacherById(Integer id){
        teacher =teacherDao.selectTeacherById(id);
        return teacher;
    }

    @Override
    public Map<String, Object> listTeacherByCurr(Integer page, Integer num) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        List<Teacher> list = this.teacherDao.selectAllTeacherByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.teacherDao.selectCountTeacher());
        return res;
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        return this.teacherDao.insertTeacher(teacher);
    }

    @Override
    public Integer updateTeacher(Teacher teacher) {
        return this.teacherDao.updateTeacher(teacher);
    }

    @Override
    public Integer delTeacherById(Integer id) {
        return this.teacherDao.deleteTeacherById(id);
    }

    @Override
    public Teacher verifyTeacher(String jobNumber, String password) {
        return this.teacherDao.selectTeacherByJobNumberAndPassword(jobNumber, password);
    }
}
