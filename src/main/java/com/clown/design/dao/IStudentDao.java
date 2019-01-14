package com.clown.design.dao;

import com.clown.design.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    int updatePasswordById(Map<String, Object> map);

    Student selectStudentById(Integer id);

    // 分页查询所有学生信息（班级可选）
    List<Student> selectAllStudentByCurr(Map<String, Object> map);
    // 统计所有学生数量
    Integer selectCountStudent(@Param("classId") Integer classId);
    // 插入学生信息
    Integer insertStudent(Student student);
    // 更新学生信息
    Integer updateStudent(Student student);
    // 根据学生ID删除学生信息
    Integer deleteStudentById(Integer id);

    // 根据学生登录名和密码查询学生信息
    Student selectStudentByStudentIdentifierAndPassword(@Param("studentIdentifier")String studentName, @Param("password")String password);
    // 根据学生ID更新学生题目ID
    Integer updateStudentInTopicIdById(@Param("topicId") Integer topicId, @Param("id") Integer id);
}
