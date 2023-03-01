use building_block;

create table responsible_users
(
  id int unsigned not null auto_increment,
  responsible_user_name varchar(64) not null,
  created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
  updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  primary key (id)
);