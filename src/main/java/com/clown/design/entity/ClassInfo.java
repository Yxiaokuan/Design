package com.clown.design.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassInfo implements Serializable {
    private Integer id;
    private String className;
    private Integer collegeId;

    private College college;
}
