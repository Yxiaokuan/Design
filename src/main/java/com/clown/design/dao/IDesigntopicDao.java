package com.clown.design.dao;

import com.clown.design.entity.Designtopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDesigntopicDao {
    List<Designtopic> selectDesigntopicByCurr(Map<String, Object> map);
    Integer selectCountDesigntopic(@Param("status") Integer status);
    Designtopic selectDesigntopicById(Integer id);
    Integer updataDesigntopicInStatusById( @Param("id" +
            "") Integer id, @Param("status") Integer status);
}
