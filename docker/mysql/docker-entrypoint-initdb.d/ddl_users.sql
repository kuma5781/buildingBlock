use building_block;

create table users
(
  id int unsigned not null auto_increment,
  school_id int unsigned not null,
  user_name varchar(64) not null,
  created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
  updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  primary key (id),
  index users_IX1(school_id)
);