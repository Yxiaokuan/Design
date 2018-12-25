package com.clown.design.service.impl;

import com.clown.design.dao.IExpertiseDao;
import com.clown.design.entity.Expertise;
import com.clown.design.service.IExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertiseServiceImpl implements IExpertiseService {
    @Autowired
    private IExpertiseDao expertiseDao;

    @Override
    public List<Expertise> listExpertise() {
        return this.expertiseDao.selectAllExpertise();
    }
}
