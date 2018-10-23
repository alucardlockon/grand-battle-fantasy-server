CREATE TABLE account
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    username varchar(100) COMMENT '用户名',
    password varchar(200) COMMENT '密码',
    email varchar(200) COMMENT '邮件',
    status tinyint(2) COMMENT '状态:0.未验证,1.已验证,2.注销',
    createIp varchar(20) COMMENT '创建ip',
    createDate datetime DEFAULT current_time,
    createUser int(10),
    updateDate datetime DEFAULT current_time,
    updateUser int(10),
    lastIp varchar(20) COMMENT '最后登录ip'
);
ALTER TABLE account COMMENT = '用户账户';



