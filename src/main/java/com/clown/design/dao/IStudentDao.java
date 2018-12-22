package com.clown.design.dao;

import com.clown.design.entity.Student;

import java.util.Map;

public interface IStudentDao {
    int updatePasswordById(Map<String, Object> map);

    Student selectStudentById(Integer id);
}
