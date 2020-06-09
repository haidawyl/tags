/*
Navicat MySQL Data Transfer

Source Server         : 114.115.143.6-huaweicloud
Source Server Version : 50621
Source Host           : 114.115.143.6:3306
Source Database       : ddmp

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-05-04 08:52:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict_common
-- ----------------------------
DROP TABLE IF EXISTS `dict_common`;
CREATE TABLE `dict_common` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category` varchar(32) NOT NULL COMMENT '所属类型',
  `code` int(11) NOT NULL COMMENT '字典编码',
  `name` varchar(255) NOT NULL COMMENT '字典名称',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态（0:废弃;1:在用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='通用字典';

-- ----------------------------
-- Records of dict_common
-- ----------------------------
INSERT INTO `dict_common` VALUES ('1', 'enterpriseNature', '1001', '全民所有制企业/集体所有制企业/联营企业/股份合作制企业', '1');
INSERT INTO `dict_common` VALUES ('2', 'enterpriseNature', '1002', '国有独资/法人独资/国有控股/法人投资或控股的有限责任公司和股份有限公司', '1');
INSERT INTO `dict_common` VALUES ('3', 'enterpriseNature', '1003', '自然人独资/自然人投资或控股的有限责任公司及自然人发起设立的股份有限公司', '1');
INSERT INTO `dict_common` VALUES ('4', 'enterpriseNature', '1004', '其他非公司企业（包括个人独资企业/合伙企业/农民专业合作社）', '1');
INSERT INTO `dict_common` VALUES ('5', 'enterpriseNature', '1005', '外国投资企业', '1');
INSERT INTO `dict_common` VALUES ('6', 'enterpriseNature', '1006', '台/港/澳投资企业', '1');
INSERT INTO `dict_common` VALUES ('7', 'enterpriseNature', '1007', '外商投资企业分支机构', '1');
INSERT INTO `dict_common` VALUES ('8', 'enterpriseNature', '1008', '常驻代表机构', '1');
INSERT INTO `dict_common` VALUES ('9', 'enterpriseNature', '1009', '外国企业在中国境内从事经营活动', '1');
INSERT INTO `dict_common` VALUES ('10', 'enterpriseNature', '1010', '外资企业', '1');
INSERT INTO `dict_common` VALUES ('11', 'enterpriseNature', '1011', '个体工商户', '1');
INSERT INTO `dict_common` VALUES ('12', 'registerStatus', '1001', '开业', '1');
INSERT INTO `dict_common` VALUES ('13', 'registerStatus', '1002', '注销', '1');
INSERT INTO `dict_common` VALUES ('14', 'registerStatus', '1003', '吊销', '1');
INSERT INTO `dict_common` VALUES ('15', 'registerStatus', '1004', '其他\r\n', '1');
INSERT INTO `dict_common` VALUES ('16', 'companyOrgType', '1001', '全民所有制', '1');
INSERT INTO `dict_common` VALUES ('17', 'companyOrgType', '1002', '集体所有制', '1');
INSERT INTO `dict_common` VALUES ('18', 'companyOrgType', '1003', '国有事业单位营业', '1');
INSERT INTO `dict_common` VALUES ('19', 'companyOrgType', '1004', '集体事业单位营业', '1');
INSERT INTO `dict_common` VALUES ('20', 'companyOrgType', '1005', '股份有限公司', '1');
INSERT INTO `dict_common` VALUES ('21', 'companyOrgType', '1006', '有限责任公司', '1');
INSERT INTO `dict_common` VALUES ('22', 'companyOrgType', '1007', '有限合伙企业', '1');
INSERT INTO `dict_common` VALUES ('23', 'companyOrgType', '1008', '集体经营单位', '1');
INSERT INTO `dict_common` VALUES ('24', 'companyOrgType', '1009', '普通合伙企业', '1');
INSERT INTO `dict_common` VALUES ('25', 'companyOrgType', '1010', '联营企业', '1');
INSERT INTO `dict_common` VALUES ('26', 'companyOrgType', '1011', '农民专业合作', '1');
INSERT INTO `dict_common` VALUES ('27', 'companyOrgType', '1012', '外国(地区)企业常驻代表机构', '1');
INSERT INTO `dict_common` VALUES ('28', 'companyOrgType', '1013', '个人独资企业', '1');
INSERT INTO `dict_common` VALUES ('29', 'companyOrgType', '1014', '个体工商户', '1');
INSERT INTO `dict_common` VALUES ('30', 'companyOrgType', '1015', '分公司或分支机构', '1');
INSERT INTO `dict_common` VALUES ('35', 'myFavorites', '1', '搜索历史', '1');
