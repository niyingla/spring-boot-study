drop table t_demo_model if exists;
create table t_demo_model (
  id bigint generated by default as identity,
  name varchar(255), note varchar(255),
  status integer,
  description varchar(255),
  create_time timestamp,
  last_modified_time timestamp,
  primary key (id)
);

insert into t_demo_model(name,status,description,create_time,last_modified_time)
VALUES
  ('test1',1,'test1',now(),now()),
  ('test2',1,'test2',now(),now()),
  ('test3',1,'test3',now(),now()),
  ('test4',1,'test4',now(),now());