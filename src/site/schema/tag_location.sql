/*
Navicat MySQL Data Transfer

Source Server         : 114.115.143.6-huaweicloud
Source Server Version : 50621
Source Host           : 114.115.143.6:3306
Source Database       : ddmp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-04 08:53:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tag_location
-- ----------------------------
DROP TABLE IF EXISTS `tag_location`;
CREATE TABLE `tag_location` (
  `id` int(11) NOT NULL COMMENT '定位ID',
  `ds_id` int(11) NOT NULL COMMENT '数据源ID',
  `table` varchar(32) DEFAULT NULL COMMENT '表名',
  `column` varchar(64) NOT NULL COMMENT '列名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签定位表';

-- ----------------------------
-- Records of tag_location
-- ----------------------------
INSERT INTO `tag_location` VALUES ('1001', '1', null, 'background.baseInfo.name');
INSERT INTO `tag_location` VALUES ('1002', '1', null, 'background.baseInfo.province');
INSERT INTO `tag_location` VALUES ('1003', '1', null, 'background.baseInfo.city');
INSERT INTO `tag_location` VALUES ('1004', '1', null, 'background.baseInfo.district');
INSERT INTO `tag_location` VALUES ('1005', '1', null, 'background.baseInfo.industryL1');
INSERT INTO `tag_location` VALUES ('1006', '1', null, 'background.baseInfo.industryL2');
INSERT INTO `tag_location` VALUES ('1007', '1', null, 'background.baseInfo.percentileScore');
INSERT INTO `tag_location` VALUES ('1008', '1', null, 'background.baseInfo.enterpriseNature');
INSERT INTO `tag_location` VALUES ('1009', '1', null, 'background.baseInfo.regCapital');
INSERT INTO `tag_location` VALUES ('1010', '1', null, 'background.baseInfo.regStatus');
INSERT INTO `tag_location` VALUES ('1011', '1', null, 'background.baseInfo.companyOrgType');
INSERT INTO `tag_location` VALUES ('1012', '1', null, 'background.baseInfo.toTime');
