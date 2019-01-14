package com.clown.design.service;

import com.clown.design.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ITeacherService {
    // 根据登录密码和教师id修改登录密码
    boolean updatePasswordById(Integer id,String password,String newPassword);
    // 根据教师id获取教师信息
    Teacher getTeacherById(Integer id);
    // 分页获取所有教师信息
    Map<String, Object> listTeacherByCurr(Integer page, Integer num);
    // 添加教师信息
    Integer addTeacher(Teacher teacher);
    // 修改教师信息
    Integer updateTeacher(Teacher teacher);
    // 根据ID删除教师信息
    Integer delTeacherById(Integer id);
    // 教师登录
    Teacher verifyTeacher(String jobNumber, String passWord);
}
