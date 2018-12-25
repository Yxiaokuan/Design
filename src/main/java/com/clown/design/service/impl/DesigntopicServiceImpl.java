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
        Map<String, Object> req2 = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        Integer size = num;
        req.put("start", start);
        req.put("size", size);
        List<Designtopic> list = this.designtopicDao.selectDesigntopicByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopic(req2));
        return res;
    }

    @Override
    public Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> req2 = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        req.put("status", status);
        req2.put("status", status);
        List<Designtopic> list = this.designtopicDao.selectDesigntopicByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopic(req2));
        return res;
    }

    @Override
    public Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status, Integer collegeId) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> req2 = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        req.put("collegeId", collegeId);
        req2.put("collegeId", collegeId);
        List<Designtopic> list = this.designtopicDao.selectDesigntopicByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopic(req2));
        return res;
    }

    @Override
    public Map<String, Object> listDesigntopicByCurr(Integer page, Integer num, Integer status, Integer collegeId, String teacherName) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> req2 = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        req.put("teacherName", teacherName);
        req2.put("teacherName", teacherName);
        List<Designtopic> list = this.designtopicDao.selectDesigntopicByCurr(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopic(req2));
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

    @Override
    public Map<String, Object> listPageDesigntopicByClassId(Integer page, Integer num, Integer classId) {
        Map<String, Object> req = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        Integer start = page==1?0:page*num-num;
        req.put("start", start);
        req.put("size", num);
        req.put("classId", classId);
        List<Designtopic> list = this.designtopicDao.selectLimitDesigntopicByClassId(req);
        res.put("list", list);
        res.put("size", list.size());
        res.put("total", this.designtopicDao.selectCountDesigntopicByClassId(classId));
        return res;
    }

    @Override
    public Integer addDesigntopic(Designtopic designtopic) {
        return this.designtopicDao.insertDesigntopic(designtopic);
    }

    @Override
    public Integer setDesigntopicInGuideTeacherById(Integer guideTeacherId, Integer id) {
        return this.designtopicDao.updateDesigntopicInGuideTeacherIdById(guideTeacherId, id);
    }
}
