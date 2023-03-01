use building_block;

create table school
(
  id int unsigned not null auto_increment,
  school_name varchar(64) not null,
  created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
  updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  primary key (id)
);