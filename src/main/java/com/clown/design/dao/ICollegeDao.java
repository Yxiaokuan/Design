package com.clown.design.dao;

import com.clown.design.entity.College;

import java.util.List;

public interface ICollegeDao {
    // 查询所有院系信息
    List<College> selectAllCollege();
}
