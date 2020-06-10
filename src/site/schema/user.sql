SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `active_code` varchar(32) DEFAULT NULL,
  `active_status` int(11) DEFAULT '0',
  `roles` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user(`username`, `password`, `email`, `roles`) VALUES('admin', '$2a$10$uQDJzgcschpReNE4PZkw4uM1iJcJSXE739HEwH5x9k29kVKk1MCAm', 'haidawyl@163.com', 'ROLE_ADMIN');
