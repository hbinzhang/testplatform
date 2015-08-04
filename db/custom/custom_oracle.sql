/* Drop Tables */

DROP TABLE filter_source;
DROP TABLE filter_severity;
DROP TABLE filter_relation;



/* Create Tables */

CREATE TABLE filter_source
(
	name varchar(100) NOT NULL ,
	PRIMARY KEY (name)
) ;


CREATE TABLE filter_severity
(
	critical number(1) NOT NULL ,
	major number(1) NOT NULL ,
	minor number(1) NOT NULL,
	warning number(1) NOT NULL 
);

CREATE TABLE filter_relation
(
	name varchar(100) NOT NULL ,
	alarm_type varchar(100) NOT NULL ,
	time_range int NOT NULL ,
	related_alarm_type varchar(1000) NOT NULL ,
	PRIMARY KEY (name)
) ;








