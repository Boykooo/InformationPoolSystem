CREATE SCHEMA ips;

CREATE TABLE ips.poolName(
  name VARCHAR(100) PRIMARY KEY ,
  length VARCHAR(100) NOT NULL,
  width VARCHAR(100) NOT NULL,
  depth FLOAT NOT NULL ,
  type VARCHAR(100) NOT NULL,
  isWorking BOOLEAN NOT NULL DEFAULT True
);

CREATE SEQUENCE ips.track_id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE ips.track(
  id INTEGER PRIMARY KEY DEFAULT nextval('ips.track_id_seq'),
  pool_name VARCHAR(100) NOT NULL,
  number INTEGER NOT NULL,
  CONSTRAINT fk_pool_id FOREIGN KEY (pool_name) REFERENCES ips.poolName(name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ips.user(
  email VARCHAR(100) PRIMARY KEY ,
  first_name VARCHAR(100) NOT NULL ,
  last_name VARCHAR(100) NOT NULL ,
  phone_number VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE ips.session(
  date TIMESTAMP ,
  cost INTEGER  NOT NULL,
  user_email VARCHAR(100),
  track_id INTEGER NOT NULL,
  PRIMARY KEY (date, track_id),
  CONSTRAINT fk_email FOREIGN KEY (user_email) REFERENCES ips.user(email) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT fk_track_id FOREIGN KEY (track_id) REFERENCES ips.track(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ips.admin(
  username VARCHAR(100) PRIMARY KEY,
  password VARCHAR(100) NOT NULL
);

CREATE SEQUENCE ips.events_id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE ips.events(
  id INTEGER PRIMARY KEY DEFAULT nextval('ips.events_id_seq'),
  description VARCHAR(1000) NOT NULL,
  image oid NOT NULL,
  startDate DATE NOT NULL,
  endDate DATE NOT NULL
);

CREATE TABLE ips.article(
  name VARCHAR(200) PRIMARY KEY,
  content VARCHAR(10000) NOT NULL
);


