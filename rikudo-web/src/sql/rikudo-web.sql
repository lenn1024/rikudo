--
create table `sequence`(
	`biz_name` varchar(50) not null comment '业务名称',
	`current_value` bigint(20) not null comment '当前id值',
	`_increament` int not null default 1 comment '步长',
	key(`biz_name`)
) ENGINE=InnoDB comment 'id生成表' DEFAULT CHARSET=utf8;

--
CREATE TABLE `sequence_block` (
  `biz_name` varchar(50) NOT NULL COMMENT '业务名称',
  `val` bigint(20) NOT NULL COMMENT '当前id值',
  KEY(`biz_name`)
) ENGINE=InnoDB COMMENT 'id区块生成表' DEFAULT CHARSET=utf8;