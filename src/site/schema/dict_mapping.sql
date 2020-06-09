/*
Navicat MySQL Data Transfer

Source Server         : 114.115.143.6-huaweicloud
Source Server Version : 50621
Source Host           : 114.115.143.6:3306
Source Database       : ddmp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-04 08:53:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict_mapping
-- ----------------------------
DROP TABLE IF EXISTS `dict_mapping`;
CREATE TABLE `dict_mapping` (
  `keyword` varchar(32) NOT NULL COMMENT '关键字',
  `table` varchar(32) NOT NULL COMMENT '表名',
  `condition` varchar(255) DEFAULT NULL COMMENT '查询条件',
  PRIMARY KEY (`keyword`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典映射表';

-- ----------------------------
-- Records of dict_mapping
-- ----------------------------
INSERT INTO `dict_mapping` VALUES ('city', 'dict_area', 'parent = \'%s\' AND `level` = 2 AND is_valid = 1 ORDER BY sort');
INSERT INTO `dict_mapping` VALUES ('companyOrgType', 'dict_common', 'category = \'%s\' AND status = 1');
INSERT INTO `dict_mapping` VALUES ('district', 'dict_area', 'parent = \'%s\' AND `level` = 3 AND is_valid = 1 ORDER BY sort');
INSERT INTO `dict_mapping` VALUES ('enterpriseNature', 'dict_common', 'category = \'%s\' AND status = 1');
INSERT INTO `dict_mapping` VALUES ('industryL1', 'dict_industry', 'c_corp = 0 AND lev = 1');
INSERT INTO `dict_mapping` VALUES ('industryL2', 'dict_industry', 'c_corp = 0 AND lev = 2 AND pid = \'%s\'');
INSERT INTO `dict_mapping` VALUES ('industryL3', 'dict_industry', 'c_corp = 0 AND lev = 3 AND pid = \'%s\'');
INSERT INTO `dict_mapping` VALUES ('industryL4', 'dict_industry', 'c_corp = 0 AND lev = 4 AND pid = \'%s\'');
INSERT INTO `dict_mapping` VALUES ('province', 'dict_area', '`level` = 1 AND is_valid = 1 ORDER BY sort');
INSERT INTO `dict_mapping` VALUES ('registerStatus', 'dict_common', 'category = \'%s\' AND status = 1');
