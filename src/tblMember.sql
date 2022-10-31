create table tblMember(
 	id int auto_increment primary key,
 	name char(20) not null,
 	phone char(20) not null,
    address char(50) not null,
 	team char(20) not null   
)ENGINE=InnoDB DEFAULT CHARSET=euckr;