package com.clown.design.dao;

import com.clown.design.entity.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClassDao {
    List<ClassInfo> selectAllClassByCollegeId(@Param("collegeId") Integer collegeId);
}
