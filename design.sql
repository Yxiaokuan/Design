/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : design

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-12-25 23:49:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `className` varchar(50) NOT NULL COMMENT '班级名称',
  `collegeId` int(4) NOT NULL COMMENT '院系ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '院系ID',
  `collegeName` varchar(50) NOT NULL COMMENT '院系名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for designtopic
-- ----------------------------
DROP TABLE IF EXISTS `designtopic`;
CREATE TABLE `designtopic` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '毕业设计课题ID',
  `topic` varchar(255) NOT NULL COMMENT '毕业设计课题题目',
  `description` varchar(255) DEFAULT NULL COMMENT '毕业设计课题描述/要求',
  `dish_teacherId` int(4) NOT NULL COMMENT '课题提出/上报教师ID',
  `guide_teacherId` int(4) DEFAULT NULL COMMENT '课题指导教师ID',
  `status` int(1) NOT NULL COMMENT '课题审核状态；0-未审核，1-审核中，2-审核通过，3-审核未通过',
  `fileUrl` varchar(255) DEFAULT NULL COMMENT '文件URL',
  `fileName` varchar(255) DEFAULT NULL COMMENT '文件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for expertise
-- ----------------------------
DROP TABLE IF EXISTS `expertise`;
CREATE TABLE `expertise` (
  `id` int(4) NOT NULL COMMENT '教师专长ID',
  `expertiseName` varchar(50) NOT NULL COMMENT '教师专长名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `roleName` varchar(50) NOT NULL COMMENT '角色姓名；登录名',
  `passWord` varchar(50) NOT NULL COMMENT '登录密码',
  `roleType` int(1) NOT NULL COMMENT '角色类型；0-领导，1-管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `studentName` varchar(50) NOT NULL COMMENT '学生姓名；系统登录名',
  `studentIdentifier` varchar(50) NOT NULL COMMENT '学生识别号；系统登录名',
  `collegeId` int(4) NOT NULL COMMENT '院系ID',
  `classId` int(4) NOT NULL COMMENT '班级ID',
  `password` varchar(50) NOT NULL COMMENT '系统登录密码',
  `topicId` int(4) DEFAULT NULL COMMENT '毕业设计课题ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `teacherName` varchar(50) NOT NULL COMMENT '教师姓名；系统登录名',
  `expertiseId` int(4) DEFAULT NULL COMMENT '教师专长ID',
  `collegeId` int(4) DEFAULT NULL COMMENT '院系ID',
  `password` varchar(50) NOT NULL COMMENT '系统登录密码',
  PRIMARY KEY (`id`),
  KEY `teacher_college_id` (`collegeId`),
  KEY `teacher_expertise_id` (`expertiseId`),
  CONSTRAINT `teacher_college_id` FOREIGN KEY (`collegeId`) REFERENCES `college` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `teacher_expertise_id` FOREIGN KEY (`expertiseId`) REFERENCES `expertise` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
