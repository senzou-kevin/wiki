create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '名称',
                         `category1_id` bigint comment '分类1',
                         `category2_id` bigint comment '分类2',
                         `descprition` varchar(200) comment '描述',
                         `cover` varchar(200) comment '封面',
                         `doc_count` int comment '文档数量',
                         `view_count` int comment '阅读数量',
                         `vote_count` int comment '点赞数量',
                         primary key (`id`)
)  engine=innodb default charset=utf8mb4 comment='电子书';
