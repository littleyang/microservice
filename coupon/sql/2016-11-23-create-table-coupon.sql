CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠码ID',
  `no` VARCHAR(64) NOT NULL COMMENT '优惠码编号',
  `member_id` varchar(256) NOT NULL COMMENT '用户ID',
  `order_id` varchar(512) NOT NULL COMMENT '订单ID',
  `amount` int(11) NOT NULL COMMENT '当前优惠码额度,整数,分为单位',
  `description` TEXT NOT NULL COMMENT '优惠码内容描述',
  `status` TINYINT(4) NOT NULL COMMENT '优惠码状态 0:正常未使用,1:已经使用，2:过期',
  `expire_date` DATETIME NOT NUll COMMENT '过期时间',
  `used_date` DATETIME DEFAULT NULl COMMENT '使用日期',
  `deleted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否软删除，0:未删除，1:删除',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '优惠码创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '优惠码更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='优惠码表';