package com.clown.design.service.impl;

import com.clown.design.dao.IClassDao;
import com.clown.design.entity.ClassInfo;
import com.clown.design.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;

    @Override
    public List<ClassInfo> listClassByCollegeId(Integer collegeId) {
        return this.classDao.selectAllClassByCollegeId(collegeId);
    }
}