CREATE TABLE IF NOT EXISTS Account (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(200) NOT NULL,
  number varchar(200) NOT NULL,
  value int(11) NOT NULL,
  PRIMARY KEY (id)
) engine=innodb;
