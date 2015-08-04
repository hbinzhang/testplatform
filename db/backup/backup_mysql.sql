SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE backup_plan;
DROP TABLE backup_history;


/* Create Tables */

CREATE TABLE backup_plan
(
  id int NOT NULL auto_increment COMMENT '编号',
	type int NOT NULL COMMENT '备份类型',
	cycle int NOT NULL COMMENT '级别',
	value int NOT NULL COMMENT '间隔',
	start_time timestamp NOT NULL COMMENT '开始时间',
	PRIMARY KEY (id)
) COMMENT = '备份计划表';


CREATE TABLE backup_history
(
  id int NOT NULL auto_increment COMMENT '编号',
  start_time timestamp NOT NULL COMMENT '开始时间',
	duration int NOT NULL COMMENT '执行时长(秒)',
	type int NOT NULL COMMENT '备份类型',
	result tinyint NOT NULL COMMENT '成功标记',
	file_path varchar(200) NULL COMMENT '数据位置',
	file_size int NULL COMMENT '数据大小(K)',
	PRIMARY KEY (id)
) COMMENT = '备份历史表';


