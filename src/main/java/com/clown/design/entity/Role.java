package com.clown.design.entity;

import lombok.Data;

@Data
public class Role {
    private Integer id;
    private String roleName;
    private String passWord;
    private Integer roleType;
}
