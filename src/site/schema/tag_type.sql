SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tag_type
-- ----------------------------
DROP TABLE IF EXISTS `tag_type`;
CREATE TABLE `tag_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `name` varchar(16) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='标签类型表';

-- ----------------------------
-- Records of tag_type
-- ----------------------------
INSERT INTO `tag_type` VALUES ('1', '基础类');
INSERT INTO `tag_type` VALUES ('2', '行为类');
INSERT INTO `tag_type` VALUES ('3', '衍生类');
