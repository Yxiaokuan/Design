package com.clown.design.service;

import com.clown.design.entity.Teacher;

public interface ITeacherService {
    //根据登录密码和教师id修改登录密码
    boolean updatePasswordById(Integer id,String password,String newPassword);
    // 根据教师id获取教师信息
    Teacher getTeacherById(Integer id);
}
