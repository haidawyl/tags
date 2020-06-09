/*
Navicat MySQL Data Transfer

Source Server         : 114.115.143.6-huaweicloud
Source Server Version : 50621
Source Host           : 114.115.143.6:3306
Source Database       : ddmp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-04 08:52:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_source
-- ----------------------------
DROP TABLE IF EXISTS `data_source`;
CREATE TABLE `data_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据源ID',
  `storage_type` varchar(16) NOT NULL COMMENT '存储类型',
  `host` varchar(32) NOT NULL COMMENT '主机或IP',
  `port` int(11) NOT NULL COMMENT '端口号',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `schema` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='数据源表';

-- ----------------------------
-- Records of data_source
-- ----------------------------
INSERT INTO `data_source` VALUES ('1', 'Solr', '47.94.37.124', '8984', 'admin', 'hvy$UhPyJd3m', 'atmebar');
INSERT INTO `data_source` VALUES ('2', 'MongoDB', '47.94.37.124', '27001', 'gagi', 'IrU2XQLaAiR8AnC$SRfVtqa1v$F', 'atme_gagi');
