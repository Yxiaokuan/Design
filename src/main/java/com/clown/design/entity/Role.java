package com.clown.design.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private Integer id;
    private String roleName;
    private String password;
    private Integer roleType;
}
