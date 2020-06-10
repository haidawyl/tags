SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites` (
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `fav_id` int(11) NOT NULL COMMENT '收藏内容ID',
  `category` tinyint(4) NOT NULL COMMENT '分类（参考字典表dict_common中myFavorites的数据）',
  `title` varchar(255) NOT NULL COMMENT '收藏内容描述',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`username`,`fav_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏夹';

-- ----------------------------
-- Records of favorites
-- ----------------------------
INSERT INTO `favorites` VALUES ('栾喜员', '135', '35', '大连市 化学原料和化学制品制造业 Top200', '2018-04-27 09:19:07');
INSERT INTO `favorites` VALUES ('牟松', '135', '35', '111', '2018-04-26 17:25:58');
