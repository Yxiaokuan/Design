package com.clown.design.controller;

import com.clown.design.entity.ClassInfo;
import com.clown.design.service.IClassService;
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
@RequestMapping("/classInfo")
public class ClassController {
    @Autowired
    private IClassService classService;

    @RequestMapping("/listClassByCollegeId")
    public Map<String, Object> listClassByCollegeId(HttpServletResponse response, HttpServletRequest request, ClassInfo classInfo) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        Integer collegeId = classInfo.getCollegeId();
        List<ClassInfo> list = this.classService.listClassByCollegeId(collegeId);
        if(list!=null) {
            res.put("isSuccessful", true);
            res.put("list", list);
        }
        return res;
    }
}
