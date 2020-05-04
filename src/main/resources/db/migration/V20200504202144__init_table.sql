create table if not exists school (
   id bigint primary key not null,
   `name` varchar(50)
);

create table if not exists student(
  id bigint primary key not null,
  `name` varchar(50),
  school_id bigint
);

create table if not exists `payment`(
  id bigint primary key not null,
  `name` varchar(50),
  amount bigint
);

create table if not exists `task`(
 id bigint primary key not null ,
 `name` varchar (50),
 `description` varchar(500)
);

create table if not exists `action_detail`(
  id bigint primary key not null ,
  `name` varchar(50),
  `type` varchar(10), -- type TASK -> task, PAYMENT -> payment
  action_id bigint
);

CREATE TABLE
hibernate_sequence
(
    next_val bigint
);