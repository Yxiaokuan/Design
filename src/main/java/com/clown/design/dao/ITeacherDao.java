package com.clown.design.dao;

import com.clown.design.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITeacherDao {
    //根据登录密码和教师id修改登录密码
    int updatePasswordById(Map<String, Object> map);
    // 根据教师id获取教师信息
    Teacher selectTeacherById(Integer id);
    // 分页查询所有教师信息
    List<Teacher> selectAllTeacherByCurr(Map<String, Object> map);
    // 统计所有教师数量
    Integer selectCountTeacher();
    // 插入教师信息
    Integer insertTeacher(Teacher teacher);
    // 更新教师信息
    Integer updateTeacher(Teacher teacher);
    // 根据教师ID删除教师信息
    Integer deleteTeacherById(Integer id);
    // 根据教师登录名和密码查询教师信息
    Teacher selectTeacherByJobNumberAndPassword(@Param("jobNumber")String jobNumber, @Param("password")String password);
}
