/*
Navicat MySQL Data Transfer

Source Server         : local_DB
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : duirddb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-04-11 14:46:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(64) NOT NULL DEFAULT '',
  `age` int(11) NOT NULL,
  `birthday` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3', 'test1', 'test@test.com', '1', '2017-04-04 02:54:18');
INSERT INTO `student` VALUES ('4', 'test1', 'test@test.com', '1', '2017-04-04 02:56:19');
INSERT INTO `student` VALUES ('8', 'test1', 'test@test.com', '1', '2017-04-04 03:59:13');
INSERT INTO `student` VALUES ('11', 'test1', 'test@test.com', '1', '2017-04-07 08:52:59');
