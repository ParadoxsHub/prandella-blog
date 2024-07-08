DROP TABLE IF EXISTS version;

CREATE TABLE if not exists version
(
    id         BIGINT    NOT NULL,
    version    BIGINT    NULL DEFAULT NULL,
    created_at timestamp NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

-- 用户表
create table if not exists "user"
(
    id         bigserial                   not null,
    username   varchar(16)                 not null,
    nickname   varchar(16)                 not null,
    password   varchar(1024)               not null,
    email      varchar(64)                 not null,
    created_by bigint                      not null,
    updated_by bigint                      not null,
    deleted_by bigint                      default NULL,
    created_at timestamp without time zone not null,
    updated_at timestamp without time zone not null,
    deleted_at timestamp without time zone default NULL,
    age        smallint,
    gender     smallint,
    is_admin   boolean,
    is_ban     boolean,
    avatar     text,
    primary key (id)
);

-- 登录历史记录
CREATE TABLE if not exists "login_history"
(
    id             bigserial   not null,
    user_id        BIGINT      NOT NULL,
    user_agent     VARCHAR(255),
    login_at       TIMESTAMP   NOT NULL,
    ip_address     VARCHAR(45) NOT NULL,
    login_success  BOOLEAN     NOT NULL DEFAULT FALSE,
    failure_reason VARCHAR(255),
    primary key (id)
);