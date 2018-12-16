package com.clown.design.dao;

import com.clown.design.entity.Designtopic;

import java.util.List;
import java.util.Map;

public interface IDesigntopicDao {
    List<Designtopic> selectDesigntopicByCurr(Map<String, Object> map);
    Integer selectCountDesigntopic();
}
