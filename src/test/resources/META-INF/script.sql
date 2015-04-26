CREATE TABLE allocation
(
  id         INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  driver_id  INT                      NOT NULL,
  shift_id   INT                      NOT NULL,
  allocation TINYINT DEFAULT 0,
  name       VARCHAR(30),
  FOREIGN KEY (driver_id) REFERENCES driver (id),
  FOREIGN KEY (shift_id) REFERENCES shift (id)
);
CREATE UNIQUE INDEX allocation_unique ON allocation (driver_id, shift_id, name);

CREATE TABLE driver
(
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  type VARCHAR(17)
);

CREATE TABLE preference
(
  id        INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  shift_id  INT                      NOT NULL,
  driver_id INT                      NOT NULL,
  value     INT
);

CREATE TABLE shift
(
  id              INT PRIMARY KEY        NOT NULL AUTO_INCREMENT,
  description     VARCHAR(20) DEFAULT '',
  type            VARCHAR(17) DEFAULT '' NOT NULL,
  resting_hours   TIME,
  working_hours   TIME,
  start_time      TIME,
  end_time        TIME,
  final_station   CHAR(2),
  initial_station CHAR(2),
  day_time        CHAR(1)
);
