create database grandbf;

drop table gbf_account;
create table gbf_account(
  id bigint primary key auto_increment,
  email varchar(50) unique comment '邮箱',
  phone varchar(30) unique comment '手机',
  username varchar(50) not null comment '用户名',
  password varchar(100) not null comment '密码',
  nickname varchar(20) comment '昵称',
  status tinyint comment '用户状态(0.未验证,1.正常,2.停用,3.封禁)',
  ban_recover_time datetime comment '封禁解封日期',
  create_time datetime,
  modify_time datetime
) comment '账户表';


