package com.clown.design.controller;

import com.clown.design.entity.Expertise;
import com.clown.design.service.IExpertiseService;
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
@RequestMapping("/expertise")
public class ExpertiseController {
    @Autowired
    private IExpertiseService expertiseService;

    @RequestMapping("/listExpertise")
    public Map<String, Object> listExpertise(HttpServletResponse response, HttpServletRequest request, Expertise expertise) throws IOException {
        Map<String, Object> res = new HashMap<>();
        res.put("isSuccessful", false);
        List<Expertise> list = this.expertiseService.listExpertise();
        if(list!=null) {
            res.put("isSuccessful", true);
            res.put("list", list);
        }
        return res;
    }
}
