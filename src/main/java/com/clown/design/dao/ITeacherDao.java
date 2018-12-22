package com.clown.design.dao;

import com.clown.design.entity.Teacher;

import java.util.Map;

public interface ITeacherDao {
    //根据登录密码和教师id修改登录密码
    int updatePasswordById(Map<String, Object> map);
    // 根据教师id获取教师信息
    Teacher selectTeacherById(Integer id);
}
