create table if not exists `subject`(
 id bigint primary key not null ,
 `name` varchar (50)
);

create table if not exists `student_subject_map`(
  student_id bigint not null ,
  subject_id bigint not null ,
  `name` varchar (50),
  primary key(student_id, subject_id)
);