-- schema seguranca
create schema if not exists seguranca;

-- papel

create sequence if not exists seguranca.sq_papel start 1;

create table if not exists seguranca.papel (
    id integer constraint pk_papel primary key,
    nome varchar(40) not null unique
);

insert into seguranca.papel values (nextval('seguranca.sq_papel'), 'administrador');

-- usuario

create sequence if not exists seguranca.sq_usuario start 1;

create table if not exists seguranca.usuario (
	id integer constraint pk_usuario primary key,
	email varchar(150) null,
	senha varchar(45) null
);

-- usuario papel

create table if not exists seguranca.usuario_papel (
	id_usuario integer constraint pfk_usuario_papel_usuario not null references seguranca.usuario (id),
  	id_papel integer constraint pfk_usuario_papel_papel not null references seguranca.papel (id)
);
