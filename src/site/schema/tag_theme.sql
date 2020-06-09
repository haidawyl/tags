/*
Navicat MySQL Data Transfer

Source Server         : 114.115.143.6-huaweicloud
Source Server Version : 50621
Source Host           : 114.115.143.6:3306
Source Database       : ddmp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-04 08:54:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tag_theme
-- ----------------------------
DROP TABLE IF EXISTS `tag_theme`;
CREATE TABLE `tag_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主题ID',
  `name` varchar(16) DEFAULT NULL COMMENT '主题名称',
  `type` varchar(16) DEFAULT NULL COMMENT '主题类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='标签主题表';

-- ----------------------------
-- Records of tag_theme
-- ----------------------------
INSERT INTO `tag_theme` VALUES ('1', '企业主题', 'ENT_ID');
