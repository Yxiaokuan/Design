package com.clown.design.service.impl;

import com.clown.design.dao.ICollegeDao;
import com.clown.design.entity.College;
import com.clown.design.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements ICollegeService {
    @Autowired
    private ICollegeDao collegeDao;

    @Override
    public List<College> listCollege() {
        return this.collegeDao.selectAllCollege();
    }
}
