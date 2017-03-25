CREATE SCHEMA ips;

CREATE SEQUENCE ips.pool_id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE ips.pool(
  id INTEGER  PRIMARY KEY DEFAULT nextval('ips.pool_id_seq'),
  name VARCHAR(100) NOT NULL,
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
  id INTEGER PRIMARY KEY DEFAULT nextval('ips.pool_id_seq'),
  pool_id INTEGER NOT NULL,
  number INTEGER NOT NULL,
  CONSTRAINT fk_pool_id FOREIGN KEY (pool_id) REFERENCES ips.pool(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ips.user(
  email VARCHAR(100) PRIMARY KEY ,
  first_name VARCHAR(100) NOT NULL ,
  last_name VARCHAR(100) NOT NULL ,
  phone_number VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE ips.session(
  time TIMESTAMP  PRIMARY KEY,
  cost INTEGER  NOT NULL,
  user_email VARCHAR(100),
  track_id INTEGER NOT NULL,
  CONSTRAINT fk_email FOREIGN KEY (user_email) REFERENCES ips.user(email) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT fk_track_id FOREIGN KEY (track_id) REFERENCES ips.track(id) ON DELETE CASCADE ON UPDATE CASCADE
);