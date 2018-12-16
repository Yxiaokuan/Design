package com.clown.design.entity;

import lombok.Data;

@Data
public class Designtopic {
    private Integer id;
    private String topic;
    private String description;
    private Integer dish_teacherId;
    private Integer guide_teacherId;
    private Integer status;
}
