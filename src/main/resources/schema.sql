  CREATE TABLE USERS(
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      login VARCHAR(32) NOT NULL ,
      mail VARCHAR(64) NOT NULL
  );

  CREATE TABLE LECTURES (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      title VARCHAR(32) NOT NULL ,
      description VARCHAR(500) NOT NULL
  );