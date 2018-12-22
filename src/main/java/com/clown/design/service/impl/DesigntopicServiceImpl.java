package com.clown.design.service.impl;

import com.clown.design.dao.IDesigntopicDao;
import com.clown.design.entity.Designtopic;
import com.clown.design.service.IDesigntopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DesigntopicServiceImpl implements IDesigntopicService {
    @Autowired
    private IDesigntopicDao designtopicDao;


    @Override
    public Map<String, Object> listDesigntopicByCurr(Integer page, Integer num) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        Integer size = num;
        req.put("start", start);
        req.put("size", size);
        List<Designtopic> list = this.designtopicDao.selectDesigntopicByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopic(null));
        return res;
    }

    @Override
    public Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        Integer size = num;
        req.put("start", start);
        req.put("size", size);
        req.put("status", status);
        List<Designtopic> list = this.designtopicDao.selectDesigntopicByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopic(status));
        return res;
    }

    @Override
    public Designtopic getDesigntopicById(Integer id) {
        return this.designtopicDao.selectDesigntopicById(id);
    }

    @Override
    public Integer setDesigntopicInStatusById(Integer id, Integer status) {
        return this.designtopicDao.updataDesigntopicInStatusById(id, status);
    }
}
