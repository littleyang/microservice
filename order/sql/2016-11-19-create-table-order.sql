CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL COMMENT '订单名称',
  `address` varchar(512) NOT NULL COMMENT '订单地址',
  `description` TEXT NOT NULL COMMENT '订单内容描述',
  `country` varchar(128) NOT NULL COMMENT '订单国家',
  `deleted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '订单是否软删除',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';