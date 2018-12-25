package com.clown.design.controller;

import com.clown.design.entity.Designtopic;
import com.clown.design.service.IDesigntopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/designtopic")
public class DesigntopicController {
    @Autowired
    private IDesigntopicService designtopicService;

    @RequestMapping("/listDesigntopicByCurr")
    public Map<String, Object> listDesigntopicByCurr(HttpServletResponse response, HttpServletRequest request, Designtopic designtopic) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String page = request.getParameter("page");
        String num = request.getParameter("num");
        String _status = request.getParameter("status");
        String _collegeId = request.getParameter("collegeId");
        String teacherName = request.getParameter("teacherName");
        if(page.equals("")) {
            res.put("message", "page不能为空！");
        } else if(num.equals("")) {
            res.put("message", "num不能为空！");
        } else {
            Map<String, Object> map;
            if(_status==null||_status.equals("")) {
                if(_collegeId==null||_collegeId.equals("")) {
                    if(teacherName==null||teacherName.equals("")) {
                        map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num));
                    } else {
                        map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num), null, null, teacherName);
                    }
                } else {
                    map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num), null, Integer.parseInt(_collegeId));
                }
            } else {
                map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num), Integer.parseInt(_status));
            }
            if(map != null) {
                res.put("isSuccessful", true);
                res.put("list", map.get("list"));
                res.put("count", map.get("size"));
                res.put("total", map.get("total"));
            } else {
                res.put("message", "查询失败！");
            }
        }
        return res;
    }

    @RequestMapping("/getDesigntopicById")
    public Map<String, Object> getDesigntopicById(HttpServletResponse response, HttpServletRequest request, Designtopic designtopic) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = designtopic.getId();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        } else {
            Designtopic data = this.designtopicService.getDesigntopicById(id);
            if(data != null) {
                res.put("isSuccessful", true);
                res.put("data", data);
            } else {
                res.put("message", "获取失败！");
            }
        }
        return res;
    }

    @RequestMapping("/setDesigntopicInStatusById")
    public Map<String, Object> setDesigntopicInStatusById(HttpServletResponse response, HttpServletRequest request, Designtopic designtopic) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = designtopic.getId();
        Integer status = designtopic.getStatus();
        if(id==null||id.equals("")) {
            res.put("message", "id不能为空！");
        } else if(status==null||status.equals("")) {
            res.put("message", "status不能为空！");
        } else if(this.designtopicService.setDesigntopicInStatusById(id, status) != -1){
            res.put("isSuccessful", true);
            res.put("message", "修改成功！");
        } else {
            res.put("message", "修改失败！");
        }
        return res;
    }

    @RequestMapping("/listPageDesigntopicByClassId")
    public Map<String, Object> listPageDesigntopicByClassId(HttpServletResponse response, HttpServletRequest request, Designtopic designtopic) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String page = request.getParameter("page");
        String num = request.getParameter("num");
        String _classId = request.getParameter("classId");
        if(page==null||page.equals("")) {
            res.put("message", "page不能为空！");
        } else if(num==null||num.equals("")) {
            res.put("message", "num不能为空！");
        } else if(_classId==null||_classId.equals("")){
            res.put("message", "classId不能为空！");
        } else {
            Map<String, Object> map = this.designtopicService.listPageDesigntopicByClassId(Integer.parseInt(page), Integer.parseInt(num), Integer.parseInt(_classId));
            if(map != null) {
                res.put("isSuccessful", true);
                res.put("list", map.get("list"));
                res.put("count", map.get("size"));
                res.put("total", map.get("total"));
            } else {
                res.put("message", "查询失败！");
            }
        }
        return res;
    }

    @RequestMapping("/addDesigntopic")
    public Map<String, Object> addDesigntopic(HttpServletResponse response, HttpServletRequest request, Designtopic designtopic) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        String topic = designtopic.getTopic();
        Integer dish_teacherId = designtopic.getDish_teacherId();
        String fileName = designtopic.getFileName();
        if(topic==null||topic.equals("")) {
            res.put("message", "topic不能为空！");
        } else if(dish_teacherId==null||dish_teacherId.equals("")) {
            res.put("message", "dish_teacherId不能为空！");
        } else if(fileName==null||fileName.equals("")) {
            res.put("message", "fileName不能为空！");
        } else if(this.designtopicService.addDesigntopic(designtopic) != -1){
            res.put("isSuccessful", true);
            res.put("message", "添加成功！");
        } else {
            res.put("message", "添加失败！");
        }
        return res;
    }

    @RequestMapping("/setDesigntopicInGuideTeacherById")
    public Map<String, Object> setDesigntopicInGuideTeacherById(HttpServletResponse response, HttpServletRequest request, Designtopic designtopic) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer id = designtopic.getId();
        Integer guide_teacherId = designtopic.getGuide_teacherId();
        if(id==null||id.equals("")){
            res.put("message", "id不能为空！");
        } else if(guide_teacherId==null||guide_teacherId.equals("")) {
            res.put("message", "guide_teacherId不能为空！");
        } else if(this.designtopicService.setDesigntopicInGuideTeacherById(guide_teacherId, id) != -1) {
            res.put("isSuccessful", true);
            res.put("message", "设置成功！");
        } else {
            res.put("message", "设置失败！");
        }
        return res;
    }
}
