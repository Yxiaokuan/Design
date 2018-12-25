package com.clown.design.controller;

import com.clown.design.entity.College;
import com.clown.design.service.ICollegeService;
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
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private ICollegeService collegeService;

    @RequestMapping("/listCollege")
    public Map<String, Object> listCollege(HttpServletResponse response, HttpServletRequest request, College college) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        List<College> list = this.collegeService.listCollege();
        if(list!=null) {
            res.put("isSuccessful", true);
            res.put("list", list);
        }
        return res;
    }
}
