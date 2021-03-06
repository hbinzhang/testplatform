SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE term_basic;
DROP TABLE term_archive;
DROP TABLE term_account;
DROP TABLE term_car;
DROP TABLE term_battery;
DROP TABLE term_charge;
DROP TABLE suite_basic;
DROP TABLE suite_command;
DROP TABLE suite_parameter;
DROP TABLE test_message;
DROP TABLE history_charge;
DROP TABLE history_event;
DROP TABLE history_fault;
DROP TABLE history_charge_process;
DROP TABLE sys_user_testsuite;




/* Create Tables */

CREATE TABLE term_basic
(
	id varchar(64) NOT NULL COMMENT '编号',
	type char(1) COMMENT '终端类型',
	manufacturer varchar(100) NOT NULL COMMENT '生产厂家',
	name varchar(100) NOT NULL COMMENT '终端名称',
	code varchar(8) NOT NULL COMMENT '设备编码',
	protocal varchar(8) NOT NULL COMMENT '支持的协议版本',
	ip varchar(16) NOT NULL COMMENT 'IP地址',
	port varchar(8) NOT NULL COMMENT '端口',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(512) COMMENT '终端描述',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) COMMENT = '测试终端表';


CREATE TABLE term_archive
(
	id varchar(64) NOT NULL COMMENT '编号',
	project varchar(100) NOT NULL COMMENT '项目名称',
	manufacturer_info varchar(100) NOT NULL COMMENT '厂家基本信息',
	model varchar(100) NOT NULL COMMENT '检测设备型号规格',
	type varchar(100) NOT NULL COMMENT '设备类型',
	manufacturer_contact varchar(200) NOT NULL COMMENT '厂家检测接口人',
	manufacturer_engineer varchar(200) NOT NULL COMMENT '厂家检测工程师',
	contact varchar(200) NOT NULL COMMENT '后台检测接口人',
	engineer varchar(200) NOT NULL COMMENT '后台检测工程师',
	test_type varchar(1) NOT NULL COMMENT '检测类型',
	test_plan varchar(512) NOT NULL COMMENT '基本检测计划',
	test_method varchar(1) NOT NULL COMMENT '检测方法',
	test_goal varchar(100) NOT NULL COMMENT '检测目标',
	protocal varchar(100) COMMENT '协议版本',
	product_name varchar(100) COMMENT '产品名称',
	product_model varchar(100) COMMENT '产品型号',
	access varchar(1) COMMENT '设备网络接入方式',
	net_type varchar(100) COMMENT '支持网络类型',
	net_model varchar(100) COMMENT '网络模块型号',
	back_protocal varchar(100) COMMENT '后台协议版本号',
	control_ver varchar(100) COMMENT '控制板软件版本号',
	monitor_ver varchar(100) COMMENT '监控板软件版本号',
	screen_ver varchar(100) COMMENT '触摸屏软件版本号',
	card_ver varchar(100) COMMENT '读卡器软件版本号',
	parent_model varchar(100) COMMENT '继承产品型号',
	parent_ver varchar(100) COMMENT '继承产品版本号',
	improvement varchar(512) COMMENT '改进主要内容',
	test_result varchar(512) COMMENT '检测结果',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) COMMENT = '终端存档记录表';

CREATE TABLE term_account
(
	id varchar(64) NOT NULL COMMENT '编号',
	card varchar(100) COMMENT '卡号',
	name varchar(100) NOT NULL COMMENT '客户姓名',
	code varchar(100) NOT NULL COMMENT '响应码',
	account_id varchar(100) NOT NULL COMMENT '客户号',
	electric_balance decimal(12,2) NOT NULL COMMENT '电费主账户余额',
	electric_available decimal(12,2) NOT NULL COMMENT '电费主账户可用余额',
	service_balance decimal(12,2) NOT NULL COMMENT '服务费账户余额',
	service_available decimal(12,2) NOT NULL COMMENT '服务费账户可用余额',
	charge_quantity decimal(12,2) NOT NULL COMMENT '本次允许充电电量',
	charge_time decimal(12,2) NOT NULL COMMENT '本次允许充电时间',
	PRIMARY KEY (id)
) COMMENT = '测试终端表';

CREATE TABLE term_car
(
	id varchar(64) NOT NULL COMMENT '编号',
	car_no varchar(100) COMMENT '车辆车牌编码',
	car_vin varchar(100) NOT NULL COMMENT '车辆VIN',
	PRIMARY KEY (id)
) COMMENT = '车牌信息表';

CREATE TABLE term_battery
(
	id varchar(64) NOT NULL COMMENT '编号',
	battery_no varchar(100) COMMENT '电池箱编码',
	battery_type varchar(100) NOT NULL COMMENT '电池类型',
	PRIMARY KEY (id)
) COMMENT = '电池箱信息表';

CREATE TABLE term_charge
(
	id varchar(64) NOT NULL COMMENT '编号',
	card varchar(100) COMMENT '卡号',
	bms varchar(100) NOT NULL COMMENT '电池BMS编码',
	start_soc varchar(100) NOT NULL COMMENT '开始充电SOC',
	end_soc varchar(100) NOT NULL COMMENT '结束充电SOC',
	charge_quantity decimal(12,2) NOT NULL COMMENT '本次累计充电量',
	charge_energy decimal(12,2) NOT NULL COMMENT '本次累计充电能',
	charge_time decimal(12,2) NOT NULL COMMENT '充电时间长度',
	full_strategy varchar(100) NOT NULL COMMENT '充电满策略',
	full_strategy_parm varchar(100) NOT NULL COMMENT '充电满策略参数',
	is_normal char(1) NOT NULL COMMENT '是否正常结束',
	start_time datetime NOT NULL COMMENT '开始日期时间',
	end_time datetime NOT NULL COMMENT '结束日期时间',
	trade_start_time datetime NOT NULL COMMENT '交易开始日期时间',
	PRIMARY KEY (id)
) COMMENT = '充电记录表';

CREATE TABLE suite_basic
(
	id varchar(64) NOT NULL COMMENT '编号',
	name varchar(100) NOT NULL COMMENT '测试集名称',
	protocal varchar(8) COMMENT '协议版本',
	create_by varchar(64) NOT NULL COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by varchar(64) NOT NULL COMMENT '更新者',
	update_date datetime NOT NULL COMMENT '更新时间',
	remarks varchar(512) COMMENT '测试集描述',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
) COMMENT = '测试集表';

CREATE TABLE suite_command
(
	id varchar(64) NOT NULL COMMENT '编号',
	command varchar(100) COMMENT '命令代码',
	PRIMARY KEY (id, command)
) COMMENT = '测试集命令表';

CREATE TABLE suite_parameter
(
	id varchar(64) NOT NULL COMMENT '编号',
	command varchar(100) COMMENT '命令代码',
	parm_name varchar(100) COMMENT '参数名',
	parm_value varchar(100) COMMENT '参数值',
	PRIMARY KEY (id, command, parm_name)
) COMMENT = '测试集命令参数表';

CREATE TABLE test_message
(
	id varchar(64) NOT NULL COMMENT '编号',
	message_time datetime COMMENT '时间',
	terminal_name varchar(100) COMMENT '终端名称',
	command varchar(100) COMMENT '报文号',
	response_time varchar(100) COMMENT '响应时间',
	orginal_message varchar(500) COMMENT '原始报文',
	decoded_message varchar(1000) COMMENT '解析报文',
	error varchar(500) COMMENT '错误',
	t1_result varchar(100) COMMENT 'T1结果',
	t2_result varchar(100) COMMENT 'T2结果',
	t3_result varchar(100) COMMENT 'T3结果',
	PRIMARY KEY (id)
) COMMENT = '测试报文表';

CREATE TABLE test_fault
(
	id varchar(64) NOT NULL COMMENT '编号',
	terminal_name varchar(100) COMMENT '终端名称',
	message_time datetime COMMENT '时间',
	entity varchar(100) COMMENT '实体',
	type datetime COMMENT '故障分类',
	note varchar(500) COMMENT '故障描述',
	attribute varchar(1000) COMMENT '属性',
	is_operation varchar(500) COMMENT '是否与运营服务相关',
	grade varchar(100) COMMENT '等级',
	treate varchar(100) COMMENT '处理措施',
	display varchar(100) COMMENT '设备告警显示要求',
	class varchar(100) COMMENT '系统管理分类',
	PRIMARY KEY (id)
) COMMENT = '测试故障报文表';



CREATE TABLE history_charge
(
	id varchar(64) NOT NULL COMMENT '编号',
	terminal_name varchar(100) COMMENT '终端名称',
	card varchar(100) COMMENT '卡号',
	bms varchar(100) NOT NULL COMMENT '电池BMS编码',
	start_soc varchar(100) NOT NULL COMMENT '开始充电SOC',
	end_soc varchar(100) NOT NULL COMMENT '结束充电SOC',
	charge_quantity decimal(12,2) NOT NULL COMMENT '本次累计充电量',
	charge_energy decimal(12,2) NOT NULL COMMENT '本次累计充电能',
	charge_time decimal(12,2) NOT NULL COMMENT '充电时间长度',
	full_strategy varchar(100) NOT NULL COMMENT '充电满策略',
	full_strategy_parm varchar(100) NOT NULL COMMENT '充电满策略参数',
	is_normal char(1) NOT NULL COMMENT '是否正常结束',
	start_time datetime NOT NULL COMMENT '开始日期时间',
	end_time datetime NOT NULL COMMENT '结束日期时间',
	trade_start_time datetime NOT NULL COMMENT '交易开始日期时间',
	PRIMARY KEY (id)
) COMMENT = '历史充电记录表';

CREATE TABLE history_event
(
	id varchar(64) NOT NULL COMMENT '编号',
	terminal_name varchar(100) COMMENT '终端名称',
	start_time datetime COMMENT '开始时间',
	end_time datetime COMMENT '结束时间',
	type varchar(100) COMMENT '事件代码',
	num decimal(12,0) COMMENT '条数',
	PRIMARY KEY (id)
) COMMENT = '历史事件记录表';

CREATE TABLE history_fault
(
	id varchar(64) NOT NULL COMMENT '编号',
	terminal_name varchar(100) COMMENT '终端名称',
	fault_time datetime COMMENT '时间',
	module_id varchar(100) COMMENT '模块编号',
	fault_code varchar(100) COMMENT '故障代码',
	PRIMARY KEY (id)
) COMMENT = '历史告警记录表';

CREATE TABLE history_charge_process
(
	id varchar(64) NOT NULL COMMENT '编号',
	terminal_name varchar(100) COMMENT '终端名称',
	charge_time datetime COMMENT '时间',
	terminal_id varchar(100) COMMENT '充电机ID',
	type varchar(100) COMMENT '充电类型',
	max_voltage decimal(12,0) COMMENT '最高允许输出电压',
	min_voltage decimal(12,0) COMMENT '最低允许输出电压',
	max_current decimal(12,0) COMMENT '最大允许输出电流',
	total_degree decimal(12,0)  COMMENT '累计充电Kwh',
	total_ah decimal(12,0)  COMMENT '累计充电Ah',
	total_time decimal(12,0)  COMMENT '累计充电时间',
	start_soc varchar(100) COMMENT '充电起始SOC',
	current_soc varchar(100) COMMENT '当前SOC',
	insert_state varchar(100) COMMENT '充电枪插入状态',
	voltage decimal(12,0) COMMENT '充电电压',
	current decimal(12,0) COMMENT '充电电流',
	power decimal(12,0) COMMENT '输出功率',
	protocal varchar(100) COMMENT '通信协议版本号',
	potevio_protocal varchar(100) COMMENT '普天通讯协议版本',
	battery_capacity varchar(100) COMMENT '整车/分箱蓄电池额定容量',
	battery_voltage varchar(100) COMMENT '整车/分箱蓄电池额定总电压',
	battery_num varchar(100) COMMENT '整车/分箱蓄电池箱数',
	battery_series_num varchar(100) COMMENT '整车/分箱电池串联数',
	battery_parallel_num varchar(100) COMMENT '整车/分箱电池并联数',
	battery_sample_num varchar(100) COMMENT '电池温度采集点数',
	battery_charge_voltage varchar(100) COMMENT '蓄电池模块最高允许充电电压',
	battery_charge_current varchar(100) COMMENT '最高允许充电电流',
	capacity varchar(100) COMMENT '标称总容量',
	charge_voltage varchar(100) COMMENT '最高允许充电总电压',
	high_temperature varchar(100) COMMENT '最高允许蓄电池温度',
	soh varchar(100) COMMENT 'SOH',
	soc varchar(100) COMMENT '整车/分箱蓄电池荷电状态',
	total_voltage varchar(100) COMMENT '整车/分箱蓄电池总电压',
	require_voltage varchar(100) COMMENT '电池组需求总电压',
	require_current varchar(100) COMMENT '电池组需求总电流',
  voltage_measure varchar(100) COMMENT '充电电压测量值',	
  current_measure varchar(100) COMMENT '充电电流测量值',	
  temperature_low varchar(100) COMMENT '电池组最低温度',
  temperature_high varchar(100) COMMENT '电池组最高温度',
  full_time varchar(100) COMMENT '估算充满时间/min',
  bms_suspend_reason varchar(100) COMMENT 'BMS 中止充电原因',
  single_voltage_min varchar(100) COMMENT '电池单体最低电压',
  single_voltage_max varchar(100) COMMENT '电池单体最高电压',
  bms_id varchar(100) COMMENT 'BMS ID',
  error varchar(100) COMMENT '错误数据',
  car_vin varchar(100) COMMENT '车辆VIN',
  num varchar(100) COMMENT '电池箱数',
  battery1 varchar(10) COMMENT '电池箱ID 1',
  battery2 varchar(10) COMMENT '电池箱ID 2',
  battery3 varchar(10) COMMENT '电池箱ID 3',
  battery4 varchar(10) COMMENT '电池箱ID 4',
  battery5 varchar(10) COMMENT '电池箱ID 5',
  battery6 varchar(10) COMMENT '电池箱ID 6',
  battery7 varchar(10) COMMENT '电池箱ID 7',
  battery8 varchar(10) COMMENT '电池箱ID 8',
	PRIMARY KEY (id)
) COMMENT = '历史充电过程记录表';


CREATE TABLE sys_user_testsuite
(
	user_id varchar(64) NOT NULL COMMENT '用户编号',
	testsuite_id varchar(64) NOT NULL COMMENT '测试集编号',
	PRIMARY KEY (user_id, testsuite_id)
) COMMENT = '用户-测试集';







