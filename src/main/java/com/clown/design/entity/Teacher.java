package com.clown.design.entity;

import lombok.Data;

@Data
public class Teacher {
    private Integer id;
    private String teacherName;
    private Integer expertiseId;
    private Integer collegeId;
    private String passWord;
}
