package com.clown.design.service;

import com.clown.design.entity.Designtopic;

import java.util.Map;

public interface IDesigntopicService {
    Map<String, Object> listDesigntopicByCurr(Integer page, Integer num);
    Designtopic getDesigntopicById(Integer id);
}
