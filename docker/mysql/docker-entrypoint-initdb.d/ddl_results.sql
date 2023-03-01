use building_block;

create table results
(
  id int unsigned not null auto_increment,
  user_id int unsigned not null,
  responsible_user_id int unsigned not null,
  point double unsigned not null,
  created_at TIMESTAMP not null default CURRENT_TIMESTAMP,
  updated_at TIMESTAMP not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  primary key (id),
  index results_IX1(user_id),
  index results_IX2(responsible_user_id)
);