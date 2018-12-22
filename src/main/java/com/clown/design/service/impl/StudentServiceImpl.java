package com.clown.design.service.impl;

import com.clown.design.dao.IStudentDao;
import com.clown.design.entity.Student;
import com.clown.design.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    private Student student ;
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
        student =studentDao.selectStudentById(id);
        return student;
    }
    

}
