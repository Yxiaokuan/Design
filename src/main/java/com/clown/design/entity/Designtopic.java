package com.clown.design.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Designtopic implements Serializable {
    private Integer id;
    private String topic;
    private String description;
    private Integer dish_teacherId;
    private Integer guide_teacherId;
    private Integer status;

//    private List<Teacher> teachers;
    private Teacher dish_teacher;
    private Teacher guide_teacher;
}
