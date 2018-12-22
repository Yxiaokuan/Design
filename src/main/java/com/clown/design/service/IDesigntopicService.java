package com.clown.design.service;

import com.clown.design.entity.Designtopic;

import java.util.Map;

public interface IDesigntopicService {
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num);
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status);
    Designtopic getDesigntopicById(Integer id);
    Integer setDesigntopicInStatusById(Integer id, Integer status);
}
