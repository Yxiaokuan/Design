package com.clown.design.service;

import com.clown.design.entity.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    // 根据登录密码和学生id修改登录密码
    boolean updatePasswordById(Integer id,String password,String newPassword);
    // 根据id获取学生信息
    Student getStudentById(Integer id);
    // 分页获取学生信息
    Map<String, Object> listStudentByCurr(Integer page, Integer num);
    // 根据班级ID分页获取学生信息
    Map<String, Object> listStudentByCurr(Integer page, Integer num, Integer classId);
    // 添加学生信息
    Integer addStudent(Student student);
    // 修改学生信息
    Integer updateStudent(Student student);
    // 根据ID删除学生信息
    Integer delStudentById(Integer id);
    // 学生登录
    Student verifyStudent(String studentIdentifier, String password);
    // 根据学生ID修改/设置题目ID
    Integer setTopicIdById(Integer topicId, Integer id);
}
