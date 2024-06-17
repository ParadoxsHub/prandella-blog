DROP TABLE IF EXISTS version;

CREATE TABLE version
(
    id BIGINT NOT NULL,
    version BIGINT NULL DEFAULT NULL ,
    CreateAt timestamp NULL DEFAULT NULL ,
    PRIMARY KEY (id)
);