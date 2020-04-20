drop table if EXISTS t_boot_area;
create table if not EXISTS t_boot_area(
	id int not null auto_increment comment '主键',
	pid int not null,
	name VARCHAR(128),
	sort int,
	primary key(id)
)