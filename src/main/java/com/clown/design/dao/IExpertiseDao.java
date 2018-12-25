package com.clown.design.dao;

import com.clown.design.entity.Expertise;

import java.util.List;

public interface IExpertiseDao {
    // 查询所有专长信息
    List<Expertise> selectAllExpertise();
}
