CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
    `name` varchar(20) NOT NULL COMMENT '姓名',
    `age` int(5) DEFAULT NULL COMMENT '年齡',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;