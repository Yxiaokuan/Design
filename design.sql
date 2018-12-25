/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : design

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-12-25 22:35:39
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
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '移应S2016-1', '1');
INSERT INTO `class` VALUES ('2', '移应S2016-2', '1');
INSERT INTO `class` VALUES ('3', '移应S2016-3', '1');
INSERT INTO `class` VALUES ('4', '模具S2016-1', '3');
INSERT INTO `class` VALUES ('5', '模具S2016-2', '3');

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
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '信息系');
INSERT INTO `college` VALUES ('2', '机械系');
INSERT INTO `college` VALUES ('3', '汽车系');
INSERT INTO `college` VALUES ('4', '电气系');

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
-- Records of designtopic
-- ----------------------------
INSERT INTO `designtopic` VALUES ('1', '基于B/S的图书管理系统', '基于B/S的图书管理系统的要求。', '1', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('2', '基于SSM的网上商城系统', '基于SSM的网上商城系统的要求。', '2', '1', '2', null, null);
INSERT INTO `designtopic` VALUES ('3', '基于SSH的驾校管理系统', '基于SSM的网上商城系统的要求。', '1', '2', '2', '', 'archivetemp1基于SSM的毕业设计选题系统设计与实现 课题任务书 .doc');
INSERT INTO `designtopic` VALUES ('4', '基于A/S的网上书店系统', '基于A/S的网上书店系统的要求。', '2', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('5', '基于B/S的图书管理系统', '是一个要求。', '4', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('6', '基于B/S的图书管理系统', '是一个要求。', '2', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('7', '基于B/S的图书管理系统', '是一个要求。', '5', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('8', '基于B/S的图书管理系统', '是一个要求。', '1', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('9', '基于B/S的图书管理系统', '是一个要求。', '1', '2', '2', null, null);
INSERT INTO `designtopic` VALUES ('10', '基于B/S的图书管理系统', '是一个要求。', '2', '2', '3', null, null);
INSERT INTO `designtopic` VALUES ('11', '基于B/S的图书管理系统', '是一个要求。', '1', '2', '3', null, null);
INSERT INTO `designtopic` VALUES ('12', '基于B/S的图书管理系统', '是一个要求。', '1', '2', '0', null, null);
INSERT INTO `designtopic` VALUES ('13', '基于B/S的图书管理系统', '是一个要求。', '2', '2', '0', null, null);
INSERT INTO `designtopic` VALUES ('14', '基于B/S的图书管理系统', '是一个要求。', '1', '2', '0', null, null);
INSERT INTO `designtopic` VALUES ('15', '课题名称1', '课题要求1', '2', null, '0', null, 'archivetemp1基于SSM的毕业设计选题系统设计与实现 课题任务书 .doc');
INSERT INTO `designtopic` VALUES ('16', '课题名称2', '课题要求2', '2', '2', '0', null, 'archivetemp1基于SSM的毕业设计选题系统设计与实现 课题任务书 .doc');
INSERT INTO `designtopic` VALUES ('17', '的穆斯林大家放慢了速度', '是多么快乐是麻烦了', '2', null, '0', null, 'archivetemp1基于SSM的毕业设计选题系统设计与实现 课题任务书 .doc');
INSERT INTO `designtopic` VALUES ('18', '上的梵蒂冈梵蒂冈点歌，了', '的身份来到调动， ；地方过分的事，发历史记录色放而是', '2', null, '0', null, 'archivetemp1基于SSM的毕业设计选题系统设计与实现 课题任务书 .doc');

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
-- Records of expertise
-- ----------------------------
INSERT INTO `expertise` VALUES ('1', '软件技术');
INSERT INTO `expertise` VALUES ('2', '移动应用');
INSERT INTO `expertise` VALUES ('3', '计算机网络');
INSERT INTO `expertise` VALUES ('4', '数字媒体');

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
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'clown', '123', '0');
INSERT INTO `role` VALUES ('2', '张三', '123', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '李寻欢', '移应S2016-1-1', '1', '1', '1234', '3');
INSERT INTO `student` VALUES ('2', '学生2号', '移应S2016-1-2', '1', '1', '123', '2');
INSERT INTO `student` VALUES ('3', '学生3号', '移应S2016-1-3', '1', '1', '123', '3');
INSERT INTO `student` VALUES ('4', '李琪琪', '移应S2016-2-1', '1', '2', '123', '4');
INSERT INTO `student` VALUES ('5', '江永', '模具S2016-1-1', '3', '4', '123', '5');
INSERT INTO `student` VALUES ('6', '李逵', '模具S2016-1-2', '3', '4', '123', '1');
INSERT INTO `student` VALUES ('8', '学生4号', '移应S2016-1-4', '1', '1', '123', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '聂时时', '1', '1', '123');
INSERT INTO `teacher` VALUES ('2', '葛木宗一郎', '1', '1', '321');
INSERT INTO `teacher` VALUES ('4', '王二狗', '4', '4', '123');
INSERT INTO `teacher` VALUES ('5', '大大怪', '1', '2', '123');
