package com.clown.design.entity;

import lombok.Data;

@Data
public class Student {
   private Integer id;
   private String studentName;
   private String studentIdentifier;
   private Integer collegeId;
   private Integer classId;
   private String password;
   private String  topicId;
}
