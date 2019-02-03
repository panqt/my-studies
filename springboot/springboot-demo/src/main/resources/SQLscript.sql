create table department
(
	department_id int not null comment '部门编号'
		primary key,
	department_name varchar(20) charset utf8 not null comment '部门名称'
)
comment '部门表'
;


create table user
(
	user_id int not null comment '用户编号'
		primary key,
	user_name varchar(20) charset utf8 not null comment '用户名称',
	create_time datetime not null comment '创建日期',
	department_id int not null comment '部门编号',
	role_id int not null comment '角色编号'
)
comment '用户表'
;


create table role
(
	role_id int not null comment '角色编号'
		primary key,
	role_name varchar(20) charset utf8 not null comment '角色名称'
)
comment '角色表'
;



create table user_role
(
	user_id int not null comment '用户编号',
	role_id int not null comment '角色编号',
	primary key (user_id, role_id)
)
comment '用户权限表'
;



