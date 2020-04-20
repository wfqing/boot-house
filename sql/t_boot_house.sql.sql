drop table if EXISTS t_boot_house;
        create table if not EXISTS  t_boot_house (
        id int not null PRIMARY KEY auto_increment,
        area_name VARCHAR(128) not null COMMENT '所在区名称',
        rent_mode VARCHAR(1) not null	comment '租赁方式 1是整租，2是合租',
        house_type VARCHAR(1) not null comment '户型',
        orientation VARCHAR(1) not null comment '朝向',
        rental int not null comment '租金',
        province int not null comment '省',
        city int not null comment '市',
        area int not null comment '区',
        address VARCHAR(256) not null comment '地址',
        pic VARCHAR(128) not null comment '图片',
        pulish_time datetime not null comment '发布时间'


        )