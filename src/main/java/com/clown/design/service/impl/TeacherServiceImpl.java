package com.clown.design.service.impl;

import com.clown.design.dao.ITeacherDao;
import com.clown.design.entity.Teacher;
import com.clown.design.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
