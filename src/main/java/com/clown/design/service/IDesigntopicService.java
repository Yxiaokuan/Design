package com.clown.design.service;

import com.clown.design.entity.Designtopic;

import java.util.Map;

public interface IDesigntopicService {
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num);
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status);
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status, Integer collegeId);
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status, Integer collegeId, String teacherName);
    Designtopic getDesigntopicById(Integer id);
    Integer setDesigntopicInStatusById(Integer id, Integer status);

    //根据班级ID分页获取所有已审核已选课题
    Map<String, Object> listPageDesigntopicByClassId(Integer page, Integer num, Integer classId);
    // 添加课题
    Integer addDesigntopic(Designtopic designtopic);
    // 根据课题ID设置课题指导老师
    Integer setDesigntopicInGuideTeacherById(Integer guideTeacherId, Integer id);
}
