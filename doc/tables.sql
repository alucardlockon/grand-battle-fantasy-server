drop table if exists  account;
CREATE TABLE account
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    username varchar(100) COMMENT '用户名',
    password varchar(200) COMMENT '密码',
    email varchar(200) COMMENT '邮件',
    status tinyint(2) COMMENT '状态:0.未验证,1.已验证,2.注销',
    create_ip varchar(20) COMMENT '创建ip',
    create_date datetime DEFAULT current_time,
    create_user int(10),
    update_date datetime DEFAULT current_time,
    update_user int(10),
    last_ip varchar(20) COMMENT '最后登录ip',
    roles varchar(100) COMMENT '角色'
);
ALTER TABLE account COMMENT = '用户账户';

drop table if exists player;
CREATE TABLE player
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    account_id int(10),
    player_code varchar(20) COMMENT '玩家账户',
    player_name varchar(20) COMMENT '玩家名称',
    gem int(10) COMMENT '宝石',
    gold int(10) COMMENT '金币',
    level int(10) COMMENT '等级',
    exp int(10) COMMENT '经验值',
    ap int(10) COMMENT '行动点',
    is_enabled bit(1) COMMENT '启用状态',
    create_date datetime DEFAULT current_time,
    create_user int(10),
    update_date datetime DEFAULT current_time,
    update_user int(10)
);
ALTER TABLE player COMMENT = '玩家账户';

drop table if exists game_character;
CREATE TABLE game_character
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    character_name varchar(20) COMMENT '角色名称',
    hp int(10) COMMENT 'hp',
    attack int(10) COMMENT '物理攻击',
    defense int(10) COMMENT '物理防御',
    intel int(10) COMMENT '魔法攻击',
    resist int(10) COMMENT '魔法防御',
    race_id int(10) COMMENT '种族id',
    element_type tinyint(4) COMMENT '元素属性类型',
    rarity tinyint(4) COMMENT '稀有度',
    max_upgrade_status tinyint(4) COMMENT '最大解放状态',
    max_hp int(10) COMMENT '最大hp',
    max_attack int(10) COMMENT '最大物理攻击',
    max_defense int(10) COMMENT '最大物理防御',
    max_intel int(10) COMMENT '最大魔法攻击',
    max_resist int(10) COMMENT '最大魔法防御',
    create_date datetime,
    create_user int(10),
    update_date datetime,
    update_user int(10)
);
ALTER TABLE game_character COMMENT = '游戏角色';


drop table if exists player_character;
CREATE TABLE player_character
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    player_id int(10)  COMMENT '玩家id',
    character_id int(10) COMMENT '游戏角色id',
    level int(10) COMMENT '等级',
    hp int(10) COMMENT 'hp',
    attack int(10) COMMENT '物理攻击',
    defense int(10) COMMENT '物理防御',
    intel int(10) COMMENT '魔法攻击',
    resist int(10) COMMENT '魔法防御',
    upgrade_status tinyint(4) COMMENT '解放状态',
    create_date datetime,
    create_user int(10),
    update_date datetime,
    update_user int(10)
);
ALTER TABLE player_character COMMENT = '玩家角色';

drop table if exists player_team;
CREATE TABLE player_team
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    player_id int(10)  COMMENT '玩家id',
    team_order int(10)  COMMENT '队伍顺序',
    team_name int(10)  COMMENT '队伍名称',
    character1_id int(10) COMMENT '位置1游戏角色id',
    character2_id int(10) COMMENT '位置2游戏角色id',
    character3_id int(10) COMMENT '位置3游戏角色id',
    character4_id int(10) COMMENT '位置4游戏角色id',
    character5_id int(10) COMMENT '位置5游戏角色id',
    character6_id int(10) COMMENT '位置6游戏角色id',
    create_date datetime,
    create_user int(10),
    update_date datetime,
    update_user int(10)
);
ALTER TABLE player_team COMMENT = '玩家编队';
