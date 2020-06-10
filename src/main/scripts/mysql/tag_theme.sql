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
