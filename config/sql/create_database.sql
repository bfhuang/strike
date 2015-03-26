--create database strike;


create table t_person(id int  NOT NULL AUTO_INCREMENT, name char(50) not null, img_path varchar(100), primary key (id));

create table t_strike
(
     person_id int ,
     strike_count int not null default 0,
     star_count int not null default 0,
     FOREIGN KEY (person_id) references t_person(id)
);

insert into t_person(name, img_path) values ('Zhang Shen','img/baymax.jpg');
insert into t_person(name, img_path) values ('Binfang Huang','img/xiaohuangren.jpeg');
insert into t_person(name, img_path) values ('KK','img/maidou.jpg');
insert into t_person(name, img_path) values ('Qiaorong Fan','img/huiguniang.jpg');

insert into t_person(person_id, strike_count, start_count) values (1,2,3);
insert into t_person(person_id, strike_count, start_count) values (2,1,1);
insert into t_person(person_id, strike_count, start_count) values (3,2,2);
insert into t_person(person_id, strike_count, start_count) values (4,2,2);
