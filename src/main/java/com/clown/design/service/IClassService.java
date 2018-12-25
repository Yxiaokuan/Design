package com.clown.design.service;

import com.clown.design.entity.ClassInfo;

import java.util.List;

public interface IClassService {
    List<ClassInfo> listClassByCollegeId(Integer collegeId);
}
