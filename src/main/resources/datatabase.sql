-- MYSQL 5.5 MyPrayer script
-- Hogly Rubio 2014-04-21
create table
    tbtablas
    (
        tbnumero int default '0' not null,
        tbcodigo varchar(30),
        tbclave varchar(30),
        tbvalstr varchar(250),
        tbvalint int,
        tbvalnum decimal(15,2),
        tbvalfec date,
        primary key (tbnumero),
        constraint uq_tbtablas_cod_cla unique (tbcodigo, tbclave)
    )
    ENGINE=InnoDB default CHARSET=latin1;
    
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100000, 'PEDIMOTI', '.', null, null, null, null);
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100001, 'PEDIMOTI', 'Vidaespiritual', null, null, null, null);
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100002, 'PEDIMOTI', 'Salud', null, null, null, null);
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100003, 'PEDIMOTI', 'Familia', null, null, null, null);
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100004, 'PEDIMOTI', 'Estudio', null, null, null, null);
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100005, 'PEDIMOTI', 'Trabajo', null, null, null, null);
insert into tbtablas (tbnumero, tbcodigo, tbclave, tbvalstr, tbvalint, tbvalnum, tbvalfec) values (100006, 'PEDIMOTI', 'Otro', null, null, null, null);

    
create table
    pedido
    (
        pedicons int default '0' not null,
        pedifech datetime,
        pedinomb varchar(100),
        peditext varchar(4000),
        pedimoti varchar(200),
        pedisexo varchar(1),
        pediigle varchar(100),
        primary key (pedicons)
    )
    ENGINE=InnoDB default CHARSET=latin1;
    