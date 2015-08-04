SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE filter_source;
DROP TABLE filter_severity;
DROP TABLE filter_relation;



/* Create Tables */

CREATE TABLE filter_source
(
	name varchar(100) NOT NULL COMMENT '告警源',
	PRIMARY KEY (name)
) COMMENT = '告警源过滤规则表';


CREATE TABLE filter_severity
(
	critical tinyint(1) NOT NULL COMMENT '严重级别',
	major tinyint(1) NOT NULL COMMENT '主要级别',
	minor tinyint(1) NOT NULL COMMENT '次要级别',
	warning tinyint(1) NOT NULL COMMENT '警告级别'
) COMMENT = '告警级别过滤规则表';

CREATE TABLE filter_relation
(
	name varchar(100) NOT NULL COMMENT '名称',
	alarm_type varchar(100) NOT NULL COMMENT '告警类型',
	time_range int NOT NULL COMMENT '时间范围(秒）',
	related_alarm_type varchar(1000) NOT NULL COMMENT '关联的告警类型',
	PRIMARY KEY (name)
) COMMENT = '告警关联过滤规则表';








