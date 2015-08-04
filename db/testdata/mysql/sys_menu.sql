# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: testplatform
# ------------------------------------------------------
# Server version 5.5.27

#
# Dumping data for table sys_menu
#

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1','0','0,','功能菜单',0,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('10','9','0,1,2,3,9,','查看',30,NULL,NULL,NULL,'0','sys:manager:view','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('11','9','0,1,2,3,9,','新增',30,NULL,NULL,NULL,'0','sys:manager:add','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('12','9','0,1,2,3,9,','修改',30,NULL,NULL,NULL,'0','sys:manager:modify','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('13','9','0,1,2,3,9,','删除',30,NULL,NULL,NULL,'0','sys:manager:delete','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('14','2','0,1,2,','区域管理',200,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('15','14','0,1,2,14','区域管理划分',30,'/test/areadivision',NULL,'user','1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('16','15','0,1,2,14,15','查看',30,NULL,NULL,NULL,'0','sys:areadivision:view','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('17','15','0,1,2,14,15','修改',40,NULL,NULL,NULL,'0','sys:areadivision:modify','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('18','2','0,1,2,','告警过滤规则',300,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('19','18','0,1,2,18,','告警源规则',30,'/custom/filter/sourcelist',NULL,'align-justify','1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('2','1','0,1,','定制管理',200,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('20','19','0,1,2,18,19,','创建',30,NULL,NULL,NULL,'0','cms:category:view','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('21','19','0,1,2,18,19,','删除',50,NULL,NULL,NULL,'0','cms:category:edit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('22','19','0,1,2,18,19,','查询',60,NULL,NULL,NULL,'0','cms:category:edit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('23','18','0,1,2,18,','告警级别规则',40,'/custom/filter/severitylist',NULL,'certificate','1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('24','1','0,1,','系统管理',300,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('25','24','0,1,24,','个人信息',30,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('27','25','0,1,24,25,','修改密码',40,'/sys/user/modifyPwd',NULL,'lock','1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('28','24','0,1,24,','操作日志',40,NULL,NULL,'lock','1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('29','28','0,1,24,28,','日志查询',30,'/sys/log',NULL,'pencil','1','sys:log:view','1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('3','2','0,1,2,','人员管理',100,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('30','24','0,1,24,','角色管理',30,NULL,NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('31','30','0,1,24,30,','角色管理',30,'/sys/role',NULL,'pencil','1','sys:role:view','1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('32','31','0,1,24,30,31,','编辑',30,NULL,NULL,'pencil','0','sys:role:edit','1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('34','61','0,1,60,61,','补采管理',30,'/test/compensate',NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('35','60','0,1,60,','数据备份',40,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('36','34','0,1,60,61,34','数据补采',30,NULL,NULL,NULL,'0','sys:compensate:comp','1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('37','35','0,1,60,35,','自动备份策略',30,'/backup/planlist',NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('38','37','0,1,60,35,37,','查询',30,NULL,NULL,'leaf','0',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('39','37','0,1,60,35,37,','修改',40,NULL,NULL,NULL,'0','sys:areadivision:modify','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('4','3','0,1,2,3,','代维人员管理',30,'/test/maintainer',NULL,'lock','1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('40','37','0,1,60,35,37,','新增',40,NULL,NULL,NULL,'0','sys:areadivision:add','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('41','37','0,1,60,35,37,','删除',40,NULL,NULL,NULL,'0','sys:areadivision:delete','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('42','35','0,1,60,35,','历史备份',40,'/backup/historylist',NULL,NULL,'1','oa:leave:edit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('43','40','0,1,60,35,42,','查询',30,NULL,NULL,NULL,'0',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('44','40','0,1,60,35,42,','删除',40,NULL,NULL,'pencil','0','sys:log:view','1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('45','23','0,1,2,18,23,','修改',30,NULL,NULL,NULL,'0','cms:site:view','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('46','23','0,1,2,18,23,','查询',50,NULL,NULL,NULL,'0','cms:site:edit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('47','18','0,1,2,18,','告警关联规则',50,'/custom/filter/relationlist',NULL,'retweet','1','cms:site:select','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('48','47','0,1,2,18,47,','创建',30,NULL,NULL,NULL,'0','cms:article:view','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('49','42','0,1,2,18,47,','修改',40,NULL,NULL,NULL,'0','cms:article:edit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('5','4','0,1,2,3,','查看',30,NULL,NULL,NULL,'0','sys:maintainer:view','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('50','42','0,1,2,18,47,','删除',50,NULL,NULL,NULL,'0','cms:article:audit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('51','42','0,1,2,18,47,','查询',60,NULL,NULL,NULL,'0','cms:article:audit','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('52','15','0,1,2,14,15','新增',40,NULL,NULL,NULL,'0','sys:areadivision:add','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('53','15','0,1,2,14,15','删除',40,NULL,NULL,NULL,'0','sys:areadivision:delete','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('6','4','0,1,2,3,','新增',30,NULL,NULL,NULL,'0','sys:maintainer:add','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('60','1','0,1,','数据管理',100,NULL,NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('61','60','0,1,60,','接口',30,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('7','4','0,1,2,3,','修改',30,NULL,NULL,NULL,'0','sys:maintainer:modify','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('70','1','0,1,','数据展示',50,NULL,NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('71','70','0,1,70,','告警展示',30,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('72','71','0,1,70,71,','告警处理',30,'/test/managedDevice/',NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('73','71','0,1,70,71,','告警统计',40,'/stat/alarm/table',NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('74','70','0,1,70,','故障工单',40,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('75','74','0,1,70,74,','工单查询 ',30,'/display/ticket/ticketlist',NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('76','70','0,1,70,','统计',50,NULL,NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('77','76','0,1,70,76,','按区域统计',30,'/stat/region/',NULL,NULL,'1',NULL,'1','2013-06-03','1','2013-06-03',NULL,'0');
INSERT INTO `sys_menu` VALUES ('8','4','0,1,2,3,','删除',30,NULL,NULL,NULL,'0','sys:maintainer:delete','1','2013-05-27','1','2013-05-27',NULL,'0');
INSERT INTO `sys_menu` VALUES ('9','3','0,1,2,3,','系统管理员管理',30,'/test/manager',NULL,NULL,'1',NULL,'1','2013-05-27','1','2013-05-27',NULL,'0');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
