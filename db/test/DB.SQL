DROP TABLE MAINTAINER;

CREATE TABLE MAINTAINER
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY COMMENT '编号',
	LOGINNAME VARCHAR(128) NOT NULL COMMENT '登陆名',
	NAME VARCHAR(128) NOT NULL COMMENT '姓名',
	TITLE varchar(100)  COMMENT '职务',
	MOBILE varchar(20)  COMMENT '手机号码',
	password varchar(128) COMMENT '登陆密码'
) COMMENT = '代维人员表';

DROP TABLE MANAGER;

CREATE TABLE MANAGER
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY COMMENT '编号',
	LOGINNAME VARCHAR(128) NOT NULL COMMENT '登陆名',
	NAME VARCHAR(128) NOT NULL COMMENT '姓名',
	TITLE varchar(100)  COMMENT '职务',
	MOBILE varchar(20)  COMMENT '手机号码',
	password varchar(128) COMMENT '登陆密码',
	email varchar(128) NOT NULL COMMENT '电子邮箱'
) COMMENT = '管理员员表';

DROP TABLE AREADIVISION;
CREATE TABLE AREADIVISION
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY COMMENT '编号',
	CODE VARCHAR(128) NOT NULL COMMENT '区域编码',
	NAME VARCHAR(128) NOT NULL COMMENT '区域名称',
	MAINTAINERS varchar(200)  COMMENT '代维人员列表',
	DEVICES varchar(60000)  COMMENT '被管网元设备列表'
) COMMENT = '区域划分';

DROP TABLE AREAMAINTAINERS;
CREATE TABLE AREAMAINTAINERS
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY COMMENT '编号',
	AREACODE VARCHAR(128) NOT NULL COMMENT '区域编码',
	MAINTAINERNAME VARCHAR(128) NOT NULL COMMENT '代维人员名称'
) COMMENT = '区域管理人员表';

DROP TABLE AREADEVICES;
CREATE TABLE AREADEVICES
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY COMMENT '编号',
	AREACODE VARCHAR(128) NOT NULL COMMENT '区域编码',
	DEVICEID VARCHAR(128) NOT NULL COMMENT '设备标识',
	DEVICENAME VARCHAR(128) NOT NULL COMMENT '设备名称'
) COMMENT = '区域设备表';

DROP TABLE manageddevice;
CREATE TABLE manageddevice
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY,
	NEID VARCHAR(128) NOT NULL,
	NENAME VARCHAR(128) NOT NULL,
	NEVERSION VARCHAR(128) NOT NULL,
	NETYPE VARCHAR(128) NOT NULL
);

DROP TABLE alarm;
CREATE TABLE alarm
(
	ID VARCHAR(128) NOT NULL PRIMARY KEY,
	streamCode VARCHAR(128) NOT NULL,
	type VARCHAR(128),
	name VARCHAR(128),
	neid VARCHAR(128),
	alarmSource VARCHAR(128),
	alarm_level VARCHAR(128),
	effect VARCHAR(128),
	description VARCHAR(128),
	createTime VARCHAR(128),
	isClear VARCHAR(128),
	clearTime VARCHAR(128),
	isAck VARCHAR(128),
	ackTime VARCHAR(128),
	maintainerId VARCHAR(128)
);

-- test data
INSERT INTO `manageddevice` VALUES ('1', '1', '海淀桥', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('2', '2', '保福寺', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('3', '3', '三元桥', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('4', '4', '七里庄', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('5', '5', '十八里店', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('6', '6', '大红门', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('7', '7', '定慧桥', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('8', '8', '积水潭', 'v1.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('9', '9', '北京SCA', 'v3.0', 'SCA');
INSERT INTO `manageddevice` VALUES ('10', '10', '北京MME', 'v2.0', 'MME');
INSERT INTO `manageddevice` VALUES ('11', '11', '北京eNodeB11', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('12', '12', '北京eNodeB12', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('13', '13', '北京eNodeB13', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('14', '14', '北京eNodeB14', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('15', '15', '北京eNodeB15', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('16', '16', '北京eNodeB16', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('17', '17', '北京eNodeB17', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('18', '18', '北京eNodeB18', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('19', '19', '北京eNodeB19', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('20', '20', '北京eNodeB20', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('21', '21', '北京eNodeB21', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('22', '22', '北京eNodeB22', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('23', '23', '北京eNodeB23', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('24', '24', '北京eNodeB24', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('25', '25', '北京eNodeB25', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('26', '26', '北京eNodeB26', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('27', '27', '北京eNodeB27', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('28', '28', '北京eNodeB28', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('29', '29', '北京eNodeB29', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('30', '30', '北京eNodeB30', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('31', '31', '北京eNodeB31', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('32', '32', '北京eNodeB32', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('33', '33', '北京eNodeB33', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('34', '34', '北京eNodeB34', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('35', '35', '北京eNodeB35', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('36', '36', '北京eNodeB36', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('37', '37', '北京eNodeB37', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('38', '38', '北京eNodeB38', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('39', '39', '北京eNodeB39', 'v2.0', 'eNodeB');
INSERT INTO `manageddevice` VALUES ('40', '40', '北京eNodeB40', 'v2.0', 'eNodeB');

INSERT INTO `alarm` VALUES ('654313164', '1', '硬件告警', 'MCB板卡掉电', '1', 'eNodeB1/EUtralCell2', '主要告警', '主控板失效', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '张三');
INSERT INTO `alarm` VALUES ('654313165', '2', '服务告警', 'CPB断连', '1', 'eNodeB1/EUtralCell2', '严重告警', 'CPB断连', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '李四');
INSERT INTO `alarm` VALUES ('654313166', '3', '软件告警', '小区退服', '3', 'eNodeB1/EUtralCell2', '次要告警', '小区退服', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '张三');
INSERT INTO `alarm` VALUES ('654313167', '4', '环境告警', '基站退服', '6', 'eNodeB1/EUtralCell2', '警告告警', '基站退服', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '李四');
INSERT INTO `alarm` VALUES ('654313168', '5', '硬件告警', '时钟失步', '7', 'eNodeB1/EUtralCell2', '主要告警', '时钟失步', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '张三');
INSERT INTO `alarm` VALUES ('654313119', '6', '环境告警', '板卡掉电', '2', 'eNodeB1/EUtralCell2', '警告告警', '板卡掉电', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '李四');
INSERT INTO `alarm` VALUES ('654313124', '7', '环境告警', 'OM断链', '9', 'eNodeB1/EUtralCell2', '主要告警', 'OM断链', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '李四');
INSERT INTO `alarm` VALUES ('654313134', '8', '软件告警', '光纤断链', '10', 'eNodeB1/EUtralCell2', '警告告警', '光纤断链', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '李四');
INSERT INTO `alarm` VALUES ('654313144', '9', '软件告警', '性能文件采集超时', '1', 'eNodeB1/EUtralCell2', '主要告警', '性能文件采集超时', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '张三');
INSERT INTO `alarm` VALUES ('654313164', '10', '服务告警', 'MCB板卡掉电', '4', 'eNodeB1/EUtralCell2', '严重告警', 'MCB板卡掉电', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '张三');
INSERT INTO `alarm` VALUES ('654313174', '11', '硬件告警', '时钟失步', '2', 'eNodeB1/EUtralCell2', '严重告警', '时钟失步', '', 'Fri Jul 31 09:40:25 CST 2015', 'NO', '', 'NO', '', '张三');

