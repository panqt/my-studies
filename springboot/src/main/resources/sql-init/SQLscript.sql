create database if not exists springboot default character set utf8mb4 collate utf8mb4_general_ci;

use springboot;

create table if not exists department
(
	department_id int not null auto_increment comment '部门编号'
		primary key,
	department_name nvarchar(20) not null comment '部门名称'
)
comment '部门表'
;


create table if not exists user
(
	user_id int not null auto_increment comment '用户编号'
		primary key,
	user_name nvarchar(20) not null comment '用户名称',
	create_time datetime not null comment '创建日期',
	department_id int not null comment '部门编号',
	role_id int not null comment '角色编号'
)
comment '用户表'
;


create table if not exists role
(
	role_id int not null auto_increment comment '角色编号'
		primary key,
	role_name nvarchar(20) not null comment '角色名称'
)
comment '角色表'
;


create table if not exists fast_file
(
	file_id varchar(190) not null  comment 'fileid'
		primary key
)
comment 'Fastdfs 文件ID'
;


INSERT INTO springboot.role (role_id, role_name) VALUES (1, '经理');
INSERT INTO springboot.role (role_id, role_name) VALUES (2, '人事');
INSERT INTO springboot.role (role_id, role_name) VALUES (3, '程序员');
INSERT INTO springboot.role (role_id, role_name) VALUES (4, '产品');
INSERT INTO springboot.role (role_id, role_name) VALUES (5, '测试');
INSERT INTO springboot.department (department_id, department_name) VALUES (1, '产品部');
INSERT INTO springboot.department (department_id, department_name) VALUES (2, '开发部');
INSERT INTO springboot.department (department_id, department_name) VALUES (3, '行政部');
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (1, '蔡东西', '2019-03-13 17:42:31', 3, 1);
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (2, '芈南北', '2019-03-13 17:43:17', 3, 2);
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (3, '尤前后', '2019-03-13 17:43:40', 2, 3);
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (4, '燕左右', '2019-03-13 17:44:22', 1, 4);
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (5, '江上下', '2019-03-13 17:45:47', 2, 5);
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (6, '楚里外', '2019-03-13 17:44:46', 2, 3);
INSERT INTO springboot.user (user_id, user_name, create_time, department_id, role_id) VALUES (7, '查虚实', '2019-03-13 17:44:46', 2, 3);
