create table role
(
	id int auto_increment
		primary key,
	roleNameEn varchar(16) not null,
	roleNameCh varchar(16) null,
	constraint id_UNIQUE
		unique (id)
)
;

create table user
(
	id int auto_increment
		primary key,
	username varchar(16) not null,
	emailAddress varchar(255) null,
	password varchar(32) not null,
	createtime timestamp default CURRENT_TIMESTAMP null,
	credits int null,
	lastIp varchar(45) null,
	lastVisitTime timestamp null,
	constraint id_UNIQUE
		unique (id)
)
comment '用户表'
;

create table user_role_re
(
	id int auto_increment
		primary key,
	userId int not null,
	roleId int null,
	constraint id_UNIQUE
		unique (id)
)
;

