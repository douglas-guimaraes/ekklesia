-- schema seguranca
create schema if not exists corporativo;

-- profissao

create sequence if not exists corporativo.sq_profissao start 1;

create table if not exists corporativo.profissao (
  id integer constraint pk_profissao primary key,
  nome varchar(150) null
);

-- membro

create sequence if not exists corporativo.sq_membro start 1;

create table if not exists corporativo.membro (
  id integer constraint pk_membro primary key,
  nome varchar(150) not null,
  data_nascimento date null,
  tp_sexo int null,
  naturalidade varchar(150) null,
  uf_naturalidade char(2) null,
  rg varchar(15) null,
  orgao_emissor_rg varchar(10) null,
  tp_escolaridade int null,
  info_adicional varchar(500) null,
  tp_alocacao int null,
  id_profissao int constraint fk_membro_profissao not null references corporativo.profissao (id),
  id_usuario int constraint fk_membro_usuario not null references seguranca.usuario (id)
);

-- estado_civil

create sequence if not exists corporativo.sq_estado_civil start 1;

create table if not exists corporativo.estado_civil (
  id integer constraint pk_estado_civil primary key,
  tp_estado_civil int not null,
  data_casamento date null,
  id_membro int not null constraint fk_estado_civil_membro not null references corporativo.membro (id)
);


-- telefone

create sequence if not exists corporativo.sq_telefone start 1;

create table if not exists corporativo.telefone (
  id integer constraint pk_telefone primary key,
  ddd char(2) not null,
  numero varchar(12) not null,
  tp_telefone int not null,
  id_membro int not null constraint fk_telefone_membro not null references corporativo.membro (id)
);

-- endereco

create sequence if not exists corporativo.sq_endereco start 1;

create table if not exists corporativo.endereco (
  id integer constraint pk_endereco primary key,
  cep char(8) not null,
  numero varchar(15) null,
  rua varchar(150) not null,
  complemento varchar(150) null,
  ponto_referencia varchar(150) null,
  uf char(2) not null,
  cidade varchar(150) not null,
  bairro varchar(150) not null,
  id_membro int not null constraint fk_endereco_membro not null references corporativo.membro (id)
);

-- procedencia

create sequence if not exists corporativo.sq_procedencia start 1;

create table if not exists corporativo.procedencia (
  id integer constraint pk_procedencia primary key,
  descricao varchar(150) not null
);

-- cargo

create sequence if not exists corporativo.sq_cargo start 1;

create table if not exists corporativo.cargo (
  id integer constraint pk_cargo primary key,
  descricao varchar(150) not null
);

--info_eclesiastica

create sequence if not exists corporativo.sq_info_eclesiastica start 1;

create table if not exists corporativo.info_eclesiastica (
  id integer constraint pk_info_eclesiastica primary key,
  tp_membro int null,
  tp_oficial int null,
  st_oficialato int null,
  tp_cadastro_rol int null,
  numero_ordem varchar(45) null,
  id_procedencia int not null constraint fk_info_eclesiastica_procedencia not null references corporativo.procedencia (id),
  id_cargo int constraint fk_info_eclesiastica_cargo not null references corporativo.cargo (id),
  id_membro int not null constraint fk_info_eclesiastica_membro not null references corporativo.membro (id)
);

-- meio_admissao

create sequence if not exists corporativo.sq_meio_admissao start 1;

create table if not exists corporativo.meio_admissao (
  id integer constraint pk_meio_admissao primary key,
  descricao varchar(45) not null
);

-- admissao

create sequence if not exists corporativo.sq_admissao start 1;

create table if not exists corporativo.admissao (
  id integer constraint pk_admissao primary key,
  data timestamp null,
  numero_ata varchar(45) null,
  igreja_origem varchar(150) null,
  pastor_origem varchar(150) null,
  data_batismo date null,
  data_profissao_fe date null,
  id_meio_admissao int not null constraint fk_admissao_meio_admissao not null references corporativo.meio_admissao (id),
  id_membro int not null constraint fk_admissao_membro not null references corporativo.membro (id),
  id_pastor_admissao int constraint fk_admissao_pastor_admissao not null references corporativo.membro (id)
);

-- batismo

create sequence if not exists corporativo.sq_batismo start 1;

create table if not exists corporativo.batismo (
  id integer constraint pk_batismo primary key,
  data date not null,
  id_membro int not null constraint fk_batismo_membro not null references corporativo.membro (id),
  id_pastor_batismo int constraint fk_batismo_pastor_batismo not null references corporativo.membro (id)
);

-- parentesco

create sequence if not exists corporativo.sq_parentesco start 1;

create table if not exists corporativo.parentesco (
  id integer constraint pk_parentesco primary key,
  tp_parentesco int null,
  nome_parentesco_nao_filiado varchar(150) null,
  id_membro int not null constraint fk_parentesco_membro not null references corporativo.membro (id),
  id_parente int constraint fk_parentesco_parente not null references corporativo.membro (id)
);

-- cadastro_membro

create sequence if not exists corporativo.sq_cadastro_membro start 1;

create table if not exists corporativo.cadastro_membro (
  id integer constraint pk_cadastro_membro primary key,
  st_cadastro varchar(45) null,
  data_criacao timestamp null,
  ultima_alteracao timestamp null,
  id_membro int not null constraint fk_cadastro_membro_membro not null references corporativo.membro (id),
  id_cadastrador int not null constraint fk_cadastro_membro_cadastrador not null references corporativo.membro (id),
  id_validador int not null constraint fk_cadastro_membro_validador not null references corporativo.membro (id)
);