
CREATE TABLE `user` (
  id int(11) NOT NULL auto_increment,
  guid varchar(255) not null unique,
  create_time datetime ,
  archived tinyint(1) default '0',
  email varchar(255),
  password varchar(255) not null,
  phone varchar(255),
  username varchar(255) not null unique,
   default_user tinyint(1) default '0',
   last_login_time datetime ,
  PRIMARY KEY  (id)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


CREATE TABLE `user_privilege` (
  user_id int(11),
  privilege varchar(255),
  KEY user_id_index (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

