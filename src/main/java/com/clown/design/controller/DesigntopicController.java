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
        if(page.equals("")) {
            res.put("message", "page不能为空！");
        } else if(num.equals("")) {
            res.put("message", "num不能为空！");
        } else {
            Map<String, Object> map;
            if(_status==null||_status.equals("")) {
                map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num));
            } else {
                map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num), Integer.parseInt(_status));
            }
            System.out.println(map);
//            Map<String, Object> map  = this.designtopicService.listDesigntopicByCurr(Integer.parseInt(page), Integer.parseInt(num));
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

}
