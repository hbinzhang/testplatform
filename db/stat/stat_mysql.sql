SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE stat_alarm_day;



/* Create Tables */

CREATE TABLE stat_alarm_day
(
	stat_time date NOT NULL COMMENT '统计日期',
	ne_id varchar(100) NOT NULL COMMENT '网元编号',
	ne_label varchar(100) NOT NULL COMMENT '网元名称',
	total int NOT NULL COMMENT '数目',
	duration int NOT NULL COMMENT '持续时间',
	criticalcount int NOT NULL COMMENT '严重告警数量',
	majorcount int NOT NULL COMMENT '主要告警数量',
	minorcount int NOT NULL COMMENT '次要告警数量',
	warncount int NOT NULL COMMENT '警告告警数量',
	PRIMARY KEY (stat_time, ne_id)
) COMMENT = '告警按日统计表';






