SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tag_mapping
-- ----------------------------
DROP TABLE IF EXISTS `tag_mapping`;
CREATE TABLE `tag_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `name` varchar(32) NOT NULL COMMENT '标签名称',
  `value_type` varchar(32) NOT NULL COMMENT '值类型',
  `theme_id` int(11) NOT NULL COMMENT '主题ID',
  `type_id` int(11) NOT NULL COMMENT '类型ID',
  `location_id` int(11) NOT NULL COMMENT '定位ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='标签映射表';

-- ----------------------------
-- Records of tag_mapping
-- ----------------------------
INSERT INTO `tag_mapping` VALUES ('1', '企业名称', 'String', '1', '1', '1001');
INSERT INTO `tag_mapping` VALUES ('2', '省份', 'Dict-Province', '1', '1', '1002');
INSERT INTO `tag_mapping` VALUES ('3', '城市', 'Dict-City', '1', '1', '1003');
INSERT INTO `tag_mapping` VALUES ('4', '区县', 'Dict-District', '1', '1', '1004');
INSERT INTO `tag_mapping` VALUES ('5', '一级行业', 'Dict-IndustryL1', '1', '1', '1005');
INSERT INTO `tag_mapping` VALUES ('6', '二级行业', 'Dict-IndustryL2', '1', '1', '1006');
INSERT INTO `tag_mapping` VALUES ('7', '企业评分', 'Integer', '1', '1', '1007');
INSERT INTO `tag_mapping` VALUES ('8', '企业性质', 'Dict-EnterpriseNature', '1', '1', '1008');
INSERT INTO `tag_mapping` VALUES ('9', '注册资金', 'Double', '1', '1', '1009');
INSERT INTO `tag_mapping` VALUES ('10', '企业状态', 'Dict-RegisterStatus', '1', '1', '1010');
INSERT INTO `tag_mapping` VALUES ('11', '企业类型', 'Dict-CompanyOrgType', '1', '1', '1011');
INSERT INTO `tag_mapping` VALUES ('12', '营业期限（至）', 'Date', '1', '1', '1012');
