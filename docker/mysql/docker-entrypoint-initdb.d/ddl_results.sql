use building_block;

create table results
(
  id int unsigned not null auto_increment,
  user_id int unsigned not null,
  result double unsigned not null,
  writer_name varchar(64) not null,
  created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
  updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  primary key (id)
);