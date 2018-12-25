package com.clown.design.service;

import com.clown.design.entity.College;

import java.util.List;

public interface ICollegeService {
    // 获取所有院系信息
    List<College> listCollege();
}
