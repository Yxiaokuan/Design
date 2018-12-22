package com.clown.design.service;

import com.clown.design.entity.Student;

public interface IStudentService {
    // 根据登录密码和学生id修改登录密码
    boolean updatePasswordById(Integer id,String password,String newPassword);
    // 根据id获取学生信息
    Student getStudentById(Integer id);
}
