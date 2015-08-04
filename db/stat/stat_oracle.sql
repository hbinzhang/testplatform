
/* Drop Tables */

DROP TABLE stat_alarm_day;



/* Create Tables */

CREATE TABLE stat_alarm_day
(
	stat_time date NOT NULL ,
	ne_id varchar(100) NOT NULL ,
	ne_label varchar(100) NOT NULL ,
	total int NOT NULL ,
	duration int NOT NULL ,
	criticalcount int NOT NULL ,
	majorcount int NOT NULL ,
	minorcount int NOT NULL ,
	warncount int NOT NULL ,
	PRIMARY KEY (stat_time, ne_id)
) ;






