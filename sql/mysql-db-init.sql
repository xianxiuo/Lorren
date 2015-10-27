drop table app.tb_user;
drop table app.tb_account;

create table app.tb_user(
    id bigint primary key auto_increment,
    name varchar(20),
    email varchar(20),
    address varchar(255),
    phone varchar(20),
    enabled boolean,
    createtime timestamp,
    updatetime timestamp,
    creator bigint
);

create table app.tb_account(
    id bigint primary key auto_increment,
    userid bigint,
    username varchar(20),
    password varchar(32),
    token text,
    enabled boolean,
    createtime timestamp,
    updatetime timestamp,
    creator bigint
);

insert into app.tb_user(id, name, email, address, phone, enabled, createtime, updatetime) values(-1, 'Lorren Wang', 'lorren@lorren.com', 'lorren address', '18600000000', true, current_timestamp, current_timestamp);
insert into app.tb_user(id, name, email, address, phone, enabled, createtime, updatetime) values(-2, 'Sorimo Chen', 'sorimo@lorren.com', 'sorimo address', '18600000000', true, current_timestamp, current_timestamp);
insert into app.tb_user(id, name, email, address, phone, enabled, createtime, updatetime) values(-3, 'Sara Du', 'sara@lorren.com', 'sara address', '18600000000', true, current_timestamp, current_timestamp);
insert into app.tb_user(id, name, email, address, phone, enabled, createtime, updatetime) values(-4, 'Sarimo Rui', 'sarimo@lorren.com', 'sarimo address', '18600000000', true, current_timestamp, current_timestamp);
insert into app.tb_user(id, name, email, address, phone, enabled, createtime, updatetime) values(-5, 'Mary Ka', 'mary@lorren.com', 'mary address', '18600000000', true, current_timestamp, current_timestamp);

insert into app.tb_account(id, userid, username, password, token, enabled, createtime, updatetime) values(-11, -1, 'lorren', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-21, -2, 'sorimo', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-31, -3, 'sara', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-41, -4, 'sarimo', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-51, -5, 'mary1', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-52, -5, 'mary2', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-53, -5, 'mary3', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-54, -5, 'mary4', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-55, -5, 'mary5', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);
insert into app.tb_account(id, userid,  username, password, token, enabled, createtime, updatetime) values(-56, -5, 'mary6', 'e99a18c428cb38d5f260853678922e03', 'e99a18c428cb38d5f260853678922e03', true, current_timestamp, current_timestamp);