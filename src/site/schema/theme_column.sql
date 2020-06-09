/*
Navicat MySQL Data Transfer

Source Server         : 114.115.143.6-huaweicloud
Source Server Version : 50621
Source Host           : 114.115.143.6:3306
Source Database       : ddmp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-04 08:54:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for theme_column
-- ----------------------------
DROP TABLE IF EXISTS `theme_column`;
CREATE TABLE `theme_column` (
  `theme_id` int(11) NOT NULL COMMENT '主题ID',
  `column` varchar(64) NOT NULL COMMENT '列名',
  `related_key` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否多数据源的关联列（0:否,1:是）',
  `ds_id` int(11) NOT NULL COMMENT '数据源ID',
  `table` varchar(32) DEFAULT NULL,
  `title` varchar(32) NOT NULL COMMENT '列表头名称',
  `width` int(11) NOT NULL DEFAULT '100' COMMENT '显示宽度',
  `visible` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否可见（0:否;1:是）',
  `default_display` tinyint(4) NOT NULL DEFAULT '0' COMMENT '默认是否显示（0:否;1:是）',
  `sort` tinyint(4) NOT NULL DEFAULT '1' COMMENT '排序',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态（0:废弃;1:在用）',
  PRIMARY KEY (`theme_id`,`column`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主题-列显示映射';

-- ----------------------------
-- Records of theme_column
-- ----------------------------
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.approvedTime', '0', '2', 'dataWareHouse', '核准日期', '100', '1', '0', '21', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.businessScope', '0', '2', 'dataWareHouse', '经营范围', '500', '1', '0', '23', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.city', '0', '1', null, '城市', '100', '1', '1', '4', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.companyOrgType', '0', '1', null, '企业类型', '200', '1', '1', '12', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.contact.email', '0', '2', 'dataWareHouse', '邮箱', '150', '1', '0', '26', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.contact.phoneNumber', '0', '2', 'dataWareHouse', '电话', '150', '1', '0', '25', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.contact.regLocation', '0', '2', 'dataWareHouse', '注册地址', '200', '1', '0', '28', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.contact.websiteList', '0', '2', 'dataWareHouse', '网址', '150', '1', '0', '27', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.creditCode', '0', '2', 'dataWareHouse', '统一信用代码', '180', '1', '0', '19', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.district', '0', '1', null, '区县', '100', '1', '0', '5', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.enterpriseNature', '0', '1', null, '企业性质', '300', '1', '1', '9', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.estiblishTime', '0', '2', 'dataWareHouse', '注册时间', '100', '1', '0', '15', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.fromTime', '0', '2', 'dataWareHouse', '营业期限（自）', '120', '1', '0', '20', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.industryL1', '0', '1', null, '一级行业', '150', '1', '1', '6', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.industryL2', '0', '1', null, '二级行业', '150', '1', '0', '7', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.legalPersonName', '0', '2', 'dataWareHouse', '企业法人', '100', '1', '0', '14', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.name', '0', '1', null, '企业名称', '200', '1', '1', '2', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.orgNumber', '0', '2', 'dataWareHouse', '组织机构代码', '150', '1', '0', '17', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.percentileScore', '0', '1', null, '企业评分', '100', '1', '0', '8', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.province', '0', '1', null, '省份', '100', '1', '1', '3', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.regCapital', '0', '1', null, '注册资金（万元）', '150', '1', '1', '10', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.regInstitute', '0', '2', 'dataWareHouse', '登记机关', '200', '1', '0', '22', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.regNumber', '0', '2', 'dataWareHouse', '工商注册号', '150', '1', '0', '16', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.regStatus', '0', '1', null, '企业状态', '80', '1', '1', '11', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.stockCode', '0', '2', 'dataWareHouse', '股票代码', '100', '1', '0', '24', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.taxNumber', '0', '2', 'dataWareHouse', '税号', '180', '1', '0', '18', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.toTime', '0', '1', null, '营业期限（至）', '120', '1', '1', '13', '1');
INSERT INTO `theme_column` VALUES ('1', 'background.baseInfo.updatetime', '0', '2', 'dataWareHouse', '更新日期', '100', '1', '0', '29', '1');
INSERT INTO `theme_column` VALUES ('1', 'id', '1', '1', null, 'ID', '80', '0', '1', '1', '1');
