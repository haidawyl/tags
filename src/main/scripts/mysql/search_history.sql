SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for search_history
-- ----------------------------
DROP TABLE IF EXISTS `search_history`;
CREATE TABLE `search_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '历史记录ID',
  `theme_id` int(11) NOT NULL COMMENT '主题ID',
  `columns` varchar(1024) DEFAULT NULL COMMENT '查询列',
  `conditions` varchar(1024) NOT NULL COMMENT '查询条件',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `limit` int(11) DEFAULT NULL COMMENT '数据量',
  `remark` varchar(1024) NOT NULL COMMENT '查询条件注解',
  `created_user` varchar(32) NOT NULL COMMENT '创建者',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of search_history
-- ----------------------------
INSERT INTO `search_history` VALUES ('62', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.enterpriseNature,background.baseInfo.regStatus', '1002 Dict-Province = 110000 AND;1005 Dict-IndustryL1 = A AND;1008 Dict-EnterpriseNature = 1001 AND', '1007 desc', '200', '搜索条件: 省份 等于 北京 AND 一级行业 等于 农、林、牧、渔业 AND 企业性质 等于 全民所有制企业/集体所有制企业/联营企业/股份合作制企业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-20 17:16:29');
INSERT INTO `search_history` VALUES ('63', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regStatus', '1002 Dict-Province = 110000 AND;1008 Dict-EnterpriseNature = 1001 AND', '1007 desc', '200', '搜索条件: 省份 等于 北京 AND 企业性质 等于 全民所有制企业/集体所有制企业/联营企业/股份合作制企业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-20 17:18:21');
INSERT INTO `search_history` VALUES ('65', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.toTime', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1002 AND', '1007 desc', '500', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 注销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 09:38:07');
INSERT INTO `search_history` VALUES ('66', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.toTime', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1002 AND', '1007 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 注销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:40:33');
INSERT INTO `search_history` VALUES ('67', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.district,background.baseInfo.industryL1,background.baseInfo.industryL2,background.baseInfo.percentileScore,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.regNumber,background.baseInfo.orgNumber,background.baseInfo.taxNumber,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.approvedTime,background.baseInfo.regInstitute,background.baseInfo.businessScope,background.baseInfo.stockCode,background.baseInfo.contact.phoneNumber,background.baseInfo.contact.email,background.baseInfo.contact.websiteList,background.baseInfo.contact.regLocation,background.baseInfo.updatetime', '1012 Date Between , 2018-12-31 AND;1002 Dict-Province = 140000 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between , 2018-12-31 AND 省份 等于 山西省 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:42:55');
INSERT INTO `search_history` VALUES ('68', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.district,background.baseInfo.industryL1,background.baseInfo.industryL2,background.baseInfo.percentileScore,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.regNumber,background.baseInfo.orgNumber,background.baseInfo.taxNumber,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.approvedTime,background.baseInfo.regInstitute,background.baseInfo.businessScope,background.baseInfo.stockCode,background.baseInfo.contact.phoneNumber,background.baseInfo.contact.email,background.baseInfo.contact.websiteList,background.baseInfo.contact.regLocation,background.baseInfo.updatetime', '1012 Date Between 2000-01-01 , 2018-12-31 AND;1002 Dict-Province = 140000 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 2000-01-01 , 2018-12-31 AND 省份 等于 山西省 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:43:23');
INSERT INTO `search_history` VALUES ('69', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.district,background.baseInfo.industryL1,background.baseInfo.industryL2,background.baseInfo.percentileScore,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.regNumber,background.baseInfo.orgNumber,background.baseInfo.taxNumber,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.approvedTime,background.baseInfo.regInstitute,background.baseInfo.businessScope,background.baseInfo.stockCode,background.baseInfo.contact.phoneNumber,background.baseInfo.contact.email,background.baseInfo.contact.websiteList,background.baseInfo.contact.regLocation,background.baseInfo.updatetime', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 开业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:48:55');
INSERT INTO `search_history` VALUES ('70', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 开业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:49:58');
INSERT INTO `search_history` VALUES ('71', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1002 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 注销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:55:38');
INSERT INTO `search_history` VALUES ('72', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 开业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:59:03');
INSERT INTO `search_history` VALUES ('73', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 开业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 09:59:33');
INSERT INTO `search_history` VALUES ('74', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1002 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 注销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:02:29');
INSERT INTO `search_history` VALUES ('75', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1003 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 吊销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:02:31');
INSERT INTO `search_history` VALUES ('76', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1004 AND', '1007 desc', '200', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 其他 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:02:51');
INSERT INTO `search_history` VALUES ('77', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1004 AND', '1012 desc', '500', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 其他 <br /> 排序: 营业期限（至） 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 10:07:58');
INSERT INTO `search_history` VALUES ('78', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND', '1012 desc', '500', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 开业 <br /> 排序: 营业期限（至） 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 10:15:57');
INSERT INTO `search_history` VALUES ('79', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1012 Date Between 1977-01-01 , 2018-11-30 AND;1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1004 AND', '1012 desc', '500', '搜索条件: 营业期限（至） Between 1977-01-01 , 2018-11-30 AND 省份 等于 山西省 AND 企业状态 等于 其他 <br /> 排序: 营业期限（至） 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 10:27:21');
INSERT INTO `search_history` VALUES ('80', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.orgNumber,background.baseInfo.stockCode', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND;1012 Date Between 1973-01-02 , 2018-10-31 AND', '1012 asc', '500', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 开业 AND 营业期限（至） Between 1973-01-02  AND  2018-10-31 <br /> 排序: 营业期限（至） 正序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 10:33:57');
INSERT INTO `search_history` VALUES ('81', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.orgNumber,background.baseInfo.fromTime', '1010 Dict-RegisterStatus = 1001 AND;1012 Date Between 1973-01-01 , 2018-12-31 AND;1002 Dict-Province = 140000 AND', '1007 desc', '500', '搜索条件: 企业状态 等于 开业 AND 营业期限（至） Between 1973-01-01 , 2018-12-31 AND 省份 等于 山西省 <br /> 排序: 企业评分 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 10:36:59');
INSERT INTO `search_history` VALUES ('82', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.creditCode,background.baseInfo.fromTime', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND;1012 Date Between 1970-01-01 , 2018-12-31 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 开业 AND 营业期限（至） Between 1970-01-01  AND  2018-12-31 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:50:15');
INSERT INTO `search_history` VALUES ('84', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.creditCode,background.baseInfo.fromTime', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1002 AND;1012 Date Between 1970-01-01 , 2018-12-31 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 注销 AND 营业期限（至） Between 1970-01-01  AND  2018-12-31 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:51:39');
INSERT INTO `search_history` VALUES ('85', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.creditCode,background.baseInfo.fromTime', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1004 AND;1012 Date Between 1970-01-01 , 2018-12-31 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 其他 AND 营业期限（至） Between 1970-01-01  AND  2018-12-31 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:52:05');
INSERT INTO `search_history` VALUES ('86', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.creditCode,background.baseInfo.fromTime', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1004 AND;1012 Date Between 1970-01-01 , 2020-12-31 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 其他 AND 营业期限（至） Between 1970-01-01  AND  2020-12-31 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 10:52:20');
INSERT INTO `search_history` VALUES ('87', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND;1012 Date Between 1998-04-04 , 2020-01-01 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 开业 AND 营业期限（至） Between 1998-04-04  AND  2020-01-01 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 11:26:11');
INSERT INTO `search_history` VALUES ('88', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1001 AND;1012 Date Between 1970-01-01 , 2020-01-01 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 开业 AND 营业期限（至） Between 1970-01-01  AND  2020-01-01 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 11:30:30');
INSERT INTO `search_history` VALUES ('89', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1003 AND;1012 Date Between 1970-01-01 , 2020-01-01 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 吊销 AND 营业期限（至） Between 1970-01-01  AND  2020-01-01 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 11:31:27');
INSERT INTO `search_history` VALUES ('90', '1', 'id,background.baseInfo.name,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1010 Dict-RegisterStatus = 1004 AND;1012 Date Between 1970-01-01 , 2020-01-01 AND', '1009 desc', '200', '搜索条件: 省份 等于 山西省 AND 企业状态 等于 其他 AND 营业期限（至） Between 1970-01-01  AND  2020-01-01 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 11:31:41');
INSERT INTO `search_history` VALUES ('92', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.legalPersonName', '1001 String = 盛世 AND;1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND', '1007 desc', '1000', '搜索条件: 企业名称 等于 盛世 AND 省份 等于 北京 AND 城市 等于 北京市 <br /> 排序: 企业评分 倒序 <br /> 数据量: 1000', '李治鹏', '2018-04-23 13:32:08');
INSERT INTO `search_history` VALUES ('93', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.legalPersonName,background.baseInfo.regInstitute,background.baseInfo.businessScope,background.baseInfo.contact.phoneNumber', '1001 String = 盛世 AND;1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND', '1007 desc', '1000', '搜索条件: 企业名称 等于 盛世 AND 省份 等于 北京 AND 城市 等于 北京市 <br /> 排序: 企业评分 倒序 <br /> 数据量: 1000', '李治鹏', '2018-04-23 13:33:45');
INSERT INTO `search_history` VALUES ('95', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.district,background.baseInfo.industryL1,background.baseInfo.industryL2,background.baseInfo.percentileScore,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.legalPersonName,background.baseInfo.estiblishTime,background.baseInfo.regNumber,background.baseInfo.orgNumber,background.baseInfo.taxNumber,background.baseInfo.creditCode,background.baseInfo.fromTime,background.baseInfo.approvedTime,background.baseInfo.regInstitute,background.baseInfo.businessScope,background.baseInfo.stockCode,background.baseInfo.contact.phoneNumber,background.baseInfo.contact.email,background.baseInfo.contact.websiteList,background.baseInfo.contact.regLocation,background.baseInfo.updatetime', '1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND;1010 Dict-RegisterStatus = 1001 AND', '1007 desc', '200', '搜索条件: 省份 等于 北京 AND 城市 等于 北京市 AND 企业状态 等于 开业 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 14:42:22');
INSERT INTO `search_history` VALUES ('96', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1003 AND', '1007 desc', '200', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 吊销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 14:50:07');
INSERT INTO `search_history` VALUES ('97', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1002 AND', '1007 desc', '200', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 注销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-23 14:52:36');
INSERT INTO `search_history` VALUES ('98', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1002 AND', '1007 desc', '500', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 注销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 14:54:21');
INSERT INTO `search_history` VALUES ('99', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1003 AND', '1007 desc', '500', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 吊销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 500', '邢艳阳', '2018-04-23 14:55:41');
INSERT INTO `search_history` VALUES ('100', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1003 AND', '1007 desc', '1000', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 吊销 <br /> 排序: 企业评分 倒序 <br /> 数据量: 1000', '邢艳阳', '2018-04-23 14:58:44');
INSERT INTO `search_history` VALUES ('101', '1', 'id,background.baseInfo.name,background.baseInfo.regCapital,background.baseInfo.toTime,background.baseInfo.estiblishTime,background.baseInfo.creditCode,background.baseInfo.contact.phoneNumber', '1002 Dict-Province = 140000 AND;1003 Dict-City = 140100 AND;1010 Dict-RegisterStatus = 1004 AND', '1007 desc', '1000', '搜索条件: 省份 等于 山西省 AND 城市 等于 太原市 AND 企业状态 等于 其他 <br /> 排序: 企业评分 倒序 <br /> 数据量: 1000', '邢艳阳', '2018-04-23 15:08:16');
INSERT INTO `search_history` VALUES ('107', '1', 'id,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.toTime,background.baseInfo.businessScope', '1011 Dict-CompanyOrgType = 1006 AND', '1007 desc', '200', '搜索条件: 企业类型 等于 有限责任公司 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-24 09:34:25');
INSERT INTO `search_history` VALUES ('108', '1', 'id,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.toTime,background.baseInfo.businessScope', '1011 Dict-CompanyOrgType = 1006 AND;1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND', '1007 desc', '200', '搜索条件: 企业类型 等于 有限责任公司 AND 省份 等于 辽宁省 AND 城市 等于 大连市 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-24 09:34:35');
INSERT INTO `search_history` VALUES ('109', '1', 'id,background.baseInfo.city,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.toTime,background.baseInfo.businessScope', '1011 Dict-CompanyOrgType = 1001 AND;1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND;1008 Dict-EnterpriseNature = 1010 AND;1010 Dict-RegisterStatus = 1002 AND', '1009 desc', '200', '搜索条件: 企业类型 等于 全民所有制 AND 省份 等于 北京 AND 城市 等于 北京市 AND 企业性质 等于 外资企业 AND 企业状态 等于 注销 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-24 09:37:41');
INSERT INTO `search_history` VALUES ('110', '1', 'id,background.baseInfo.toTime', '1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND;1011 Dict-CompanyOrgType = 1005 AND', '1012 desc', '100', '搜索条件: 省份 等于 辽宁省 AND 城市 等于 大连市 AND 企业类型 等于 股份有限公司 <br /> 排序: 营业期限（至） 倒序 <br /> 数据量: 100', '邢艳阳', '2018-04-24 09:45:12');
INSERT INTO `search_history` VALUES ('111', '1', 'id,background.baseInfo.name,background.baseInfo.enterpriseNature,background.baseInfo.toTime,background.baseInfo.orgNumber', '1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND;1011 Dict-CompanyOrgType = 1005 AND', '1012 desc', '100', '搜索条件: 省份 等于 辽宁省 AND 城市 等于 大连市 AND 企业类型 等于 股份有限公司 <br /> 排序: 营业期限（至） 倒序 <br /> 数据量: 100', '邢艳阳', '2018-04-24 09:45:47');
INSERT INTO `search_history` VALUES ('126', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND;1011 Dict-CompanyOrgType = 1001 AND;1010 Dict-RegisterStatus = 1001 AND', '1009 desc', '200', '搜索条件: 省份 等于 北京 AND 城市 等于 北京市 AND 企业类型 等于 全民所有制 AND 企业状态 等于 开业 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 14:13:48');
INSERT INTO `search_history` VALUES ('127', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND', '1007 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 辽宁省 AND 城市 等于 大连市 <br /> 排序: 企业评分 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:32:44');
INSERT INTO `search_history` VALUES ('128', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND', '1009 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 辽宁省 AND 城市 等于 大连市 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:33:05');
INSERT INTO `search_history` VALUES ('129', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND;1006 Dict-IndustryL2 = J66 AND', '1009 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 北京 AND 城市 等于 北京市 AND 二级行业 等于 货币金融服务 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:34:39');
INSERT INTO `search_history` VALUES ('130', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 110000 AND;1003 Dict-City = 110100 AND;1006 Dict-IndustryL2 = J67 AND', '1009 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 北京 AND 城市 等于 北京市 AND 二级行业 等于 资本市场服务 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:35:05');
INSERT INTO `search_history` VALUES ('131', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND;1006 Dict-IndustryL2 = J67 AND', '1009 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 辽宁省 AND 城市 等于 大连市 AND 二级行业 等于 资本市场服务 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:37:04');
INSERT INTO `search_history` VALUES ('132', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND;1006 Dict-IndustryL2 = J67 AND', '1009 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 辽宁省 AND 城市 等于 大连市 AND 二级行业 等于 资本市场服务 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:40:51');
INSERT INTO `search_history` VALUES ('133', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime', '1005 Dict-IndustryL1 = J AND;1002 Dict-Province = 210000 AND;1003 Dict-City = 210200 AND;1006 Dict-IndustryL2 = J69 AND', '1009 desc', '200', '搜索条件: 一级行业 等于 金融业 AND 省份 等于 辽宁省 AND 城市 等于 大连市 AND 二级行业 等于 其他金融业 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 15:48:00');
INSERT INTO `search_history` VALUES ('134', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime', '1002 Dict-Province = 350000 AND;1006 Dict-IndustryL2 = C26 AND;1003 Dict-City = 350500 AND;1005 Dict-IndustryL1 = C AND', '1009 desc', '200', '搜索条件: 省份 等于 福建省 AND 二级行业 等于 化学原料和化学制品制造业 AND 城市 等于 泉州市 AND 一级行业 等于 制造业 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 17:05:30');
INSERT INTO `search_history` VALUES ('135', '1', 'id,background.baseInfo.name,background.baseInfo.province,background.baseInfo.city,background.baseInfo.industryL1,background.baseInfo.enterpriseNature,background.baseInfo.regCapital,background.baseInfo.regStatus,background.baseInfo.companyOrgType,background.baseInfo.toTime,background.baseInfo.estiblishTime', '1002 Dict-Province = 210000 AND;1006 Dict-IndustryL2 = C26 AND;1003 Dict-City = 210200 AND;1005 Dict-IndustryL1 = C AND', '1009 desc', '200', '搜索条件: 省份 等于 辽宁省 AND 二级行业 等于 化学原料和化学制品制造业 AND 城市 等于 大连市 AND 一级行业 等于 制造业 <br /> 排序: 注册资金 倒序 <br /> 数据量: 200', '邢艳阳', '2018-04-26 17:13:03');