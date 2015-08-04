/* Drop Tables */

DROP TABLE backup_plan;
DROP TABLE backup_history;

/* create sequence */
create or replace sequence backup_plan_seq start with 1 increment by 1;
create or replace sequence backup_history_seq start with 1 increment by 1;

/* Create Tables */

CREATE TABLE backup_plan
(
  id int NOT NULL  ,
	type int NOT NULL ,
	cycle int NOT NULL ,
	value int NOT NULL ,
	start_time timestamp NOT NULL ,
	PRIMARY KEY (id)
) ;

create or replace trigger backup_plan_trigger        
before insert on backup_plan        
for each row        
begin        
select backup_plan_seq.nextval into :new.id from dual;       
end ;    


CREATE TABLE backup_history
(
  id int NOT NULL  ,
  start_time timestamp NOT NULL ,
  duration int NOT NULL ,
  type int NOT NULL ,
  result number(1) NOT NULL ,
  file_path varchar(200) NULL ,
  file_size int NULL ,
  PRIMARY KEY (id)
) ;

create or replace trigger backup_history_trigger        
before insert on backup_history        
for each row        
begin        
select backup_history.nextval into :new.id from dual;       
end ;   

