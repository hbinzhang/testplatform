
/* Drop Tables */

DROP TABLE ticket_info;
DROP TABLE ticket_track;
DROP TABLE ticket_process;



/* Create Tables */

CREATE TABLE ticket_info
(
  ticket_id varchar(64) NOT NULL ,
  ne_id varchar(100) NOT NULL ,
  ne_label varchar(100) NOT NULL ,
  maintainer_id varchar(64) NOT NULL ,
  create_time timestamp NOT NULL ,
  detail varchar(1000) NOT NULL ,
  flag int NOT NULL ,
  end_time timestamp NULL ,
  result varchar(1000) NULL ,
  PRIMARY KEY (ticket_id)
);


CREATE TABLE ticket_track
(
  ticket_id varchar(64) NOT NULL ,
  record_time timestamp NOT NULL ,
  longtitude number(10,6) NOT NULL ,
  latitude number(10,6) NOT NULL ,
  altitude number(10,4) NOT NULL ,
  PRIMARY KEY (ticket_id, record_time)
) ;

CREATE TABLE ticket_process
(
  ticket_id varchar(64) NOT NULL ,
  process_time timestamp NOT NULL ,
  process_result varchar(1000) NOT NULL ,
  PRIMARY KEY (ticket_id, process_time)
) ;


