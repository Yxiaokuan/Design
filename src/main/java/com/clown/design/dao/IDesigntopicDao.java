package com.clown.design.dao;

import com.clown.design.entity.Designtopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDesigntopicDao {
    List<Designtopic> selectDesigntopicByCurr(Map<String, Object> map);

    Integer selectCountDesigntopic(Map<String, Object> map);

    Designtopic selectDesigntopicById(Integer id);
    Integer updataDesigntopicInStatusById(@Param("id") Integer id, @Param("status") Integer status);

    // 根据班级ID分页查询所有已审核已选课题
    List<Designtopic> selectLimitDesigntopicByClassId(Map<String, Object> map);
    // 根据班级ID统计查询所有已审核已选课题
    Integer selectCountDesigntopicByClassId(Integer classId);
    // 插入课题
    Integer insertDesigntopic(Designtopic designtopic);
    // 根据课题ID更新课题指导老师ID
    Integer updateDesigntopicInGuideTeacherIdById(@Param("teacherId")Integer teacherId, @Param("id")Integer id);
}
