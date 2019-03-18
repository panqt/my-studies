create database if not exists springboot_demo default character set utf8mb4 collate utf8mb4_general_ci;
use springboot_demo;
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


INSERT INTO springboot_demo.role (role_id, role_name) VALUES (1, '经理');
INSERT INTO springboot_demo.role (role_id, role_name) VALUES (2, '人事');
INSERT INTO springboot_demo.role (role_id, role_name) VALUES (3, '程序员');
INSERT INTO springboot_demo.role (role_id, role_name) VALUES (4, '产品');
INSERT INTO springboot_demo.role (role_id, role_name) VALUES (5, '测试');
INSERT INTO springboot_demo.role (role_id, role_name) VALUES (6, '销售');
INSERT INTO springboot_demo.department (department_id, department_name) VALUES (1, '销售部');
INSERT INTO springboot_demo.department (department_id, department_name) VALUES (2, '开发部');
INSERT INTO springboot_demo.department (department_id, department_name) VALUES (3, '行政部');
INSERT INTO springboot_demo.user (user_id, user_name, create_time, department_id, role_id) VALUES (1, '樊超', '2019-03-13 17:42:31', 2, 1);
INSERT INTO springboot_demo.user (user_id, user_name, create_time, department_id, role_id) VALUES (2, '李敏莉', '2019-03-13 17:43:17', 3, 2);
INSERT INTO springboot_demo.user (user_id, user_name, create_time, department_id, role_id) VALUES (3, '李涛', '2019-03-13 17:43:40', 2, 3);
INSERT INTO springboot_demo.user (user_id, user_name, create_time, department_id, role_id) VALUES (4, '李启豪', '2019-03-13 17:44:22', 2, 4);
INSERT INTO springboot_demo.user (user_id, user_name, create_time, department_id, role_id) VALUES (5, '邹雅芳', '2019-03-13 17:45:47', 2, 5);
INSERT INTO springboot_demo.user (user_id, user_name, create_time, department_id, role_id) VALUES (6, '李强', '2019-03-13 17:44:46', 1, 6);




create table if not exists fastfile
(
	file_id varchar(190) not null  comment '文件ID'
		primary key
)
	comment 'Fastdfs 文件ID'
;

