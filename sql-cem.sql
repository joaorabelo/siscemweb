create database cem;

use cem;

create table Responsaveis (
	id_resp int(3) primary key auto_increment,
    nom_resp varchar(200) not null,
    dt_nasc_resp date not null,
    cpf_resp int(11) not null,
    rg_resp varchar(10) not null,
    sexo_resp char(1) not null,
    fone_resp int(12) not null,
    fone_resp2 int(12) null,
    id_end int(3) not null
);

create table Alunos (
	mat_alu int(11) primary key not null,
    nom_alu varchar(200) not null,
    dt_nasc_alu date not null,
    sexo_alu char(1) not null,
    loc_nasc_alu varchar(50) not null,
    fili_alu varchar(200) not null,
    prof_fili_alu varchar(50) not null,
    fili_alu2 varchar(200) not null,
    prof_fili_alu2 varchar(50) not null,
    status_alu varchar(10) not null,
    path_foto_alu varchar(100) null,
    cpf_alu int(11) not null,
    rg_alu varchar(10) not null,
    fone_resp int(12) not null,
    fone_resp2 int(12) null,
    obs_alu text null,
    id_resp int(2) not null,
    id_end int(3) not null
);

alter table Alunos add constraint fk_resp_alu foreign key (id_resp) references Responsaveis (id_resp);

create table Enderecos (
	id_end int(3) primary key auto_increment,
    uf_end varchar(40) not null,
    cid_end varchar(40) not null,
    local_end varchar(40) not null,
    bai_end varchar(40) not null,
    comp_end varchar(30) null,
    num_end int(5) not null,
    cep int(7) not null
);

alter table Alunos add constraint fk_end_alu foreign key (id_end) references Enderecos (id_end);

alter table Responsaveis add constraint fk_end_res foreign key (id_end) references Enderecos (id_end);

create table Turmas (
	id_tur int(5) primary key auto_increment,
    ano_tur int(4) not null,
    med_tru decimal(4,2) not null default 0,
    tot_apr_tur int(2) not null default 0,
    tot_rep_tur int(2) not null default 0,
    ser_tur int(2) not null,
    tur_tur varchar(11) not null,
    car_hor_tur int(3) null
);

create table Alu_Tur (
	mat_alu int(11) not null,
    id_tur int(3) not null
);

alter table Alu_Tur add constraint fk_alu_tur foreign key (mat_alu) references Alunos (mat_alu);

alter table Alu_Tur add constraint fk_tur_alu foreign key (id_tur) references Turmas (id_tur);

create table Professores (
	mat_prof int(11) primary key not null,
    nom_prof varchar(200) not null,
    cpf_prof int(11) not null,
    rg_prof varchar(10) not null,
    fone_prof int(12) not null,
    fone_prof2 int(12) null,
    id_end int(3) not null
);

alter table Professores add constraint fk_prof_end foreign key (id_end) references Enderecos (id_end);

create table Tur_Prof (
	id_tur int(5) not null,
    mat_prof int(11) not null
);

alter table Tur_Prof add constraint fk_tur_prof foreign key (id_tur) references Turmas (id_tur);

alter table Tur_Prof add constraint fk_prof_tur foreign key (mat_prof) references Professores (mat_prof);

create table Disciplinas (
	id_disc int(2) primary key auto_increment,
    nom_disc varchar(50) not null,
    tipo_disc varchar(30) null
);

create table Tur_Disc (
	id_tur int(5) not null,
    id_disc int(2) not null,
    lim_fal_disc int(2) not null,
    car_hr_disc int(3) null
);

alter table Tur_Disc add constraint fk_tur_disc foreign key (id_tur) references Turmas (id_tur);

alter table Tur_Disc add constraint fk_disc_tur foreign key (id_disc) references Disciplinas (id_disc);

create table Disc_Prof (
	id_disc int(2) not null,
    mat_prof int(11) not null
);

alter table Disc_Prof add constraint fk_disc_prof foreign key (id_disc) references Disciplinas (id_disc);

alter table Disc_Prof add constraint fk_prof_disc foreign key (mat_prof) references Professores (mat_prof);

create table Boletins (
	ano int(4) primary key not null,
    prova decimal(4,2) null,
    acordo decimal(4,2) null,
    outro decimal(4,2) null,
    simulado decimal(4,2) null,
    faltas decimal(4,2) null,
    obs text null,
    unidade int(1) not null,
    id_disc int(2) not null,
    mat_prof int(11) not null,
    mat_alu int(11) not null
);

alter table Boletins add constraint fk_bol_disc foreign key (id_disc) references Disciplinas (id_disc);

alter table Boletins add constraint fk_bol_prof foreign key (mat_prof) references Professores (mat_prof);

alter table Boletins add constraint fk_bol_alu foreign key (mat_alu) references Alunos (mat_alu);

create table Recuperacoes (
	rec_sem decimal(4,2) null,
    rec_sem2 decimal(4,2) null,
    rec_fim decimal(4,2) null,
    ano_rec int(4) not null,
    mat_alu int(11) not null,
    id_disc int(2) not null,
    id_tur int(5) not null
);

alter table Recuperacoes add constraint fk_rec_alu foreign key (mat_alu) references Alunos (mat_alu);

alter table Recuperacoes add constraint fk_rec_disc foreign key (id_disc) references Disciplinas (id_disc);

alter table Recuperacoes add constraint fk_rec_tur foreign key (id_tur) references Turmas (id_tur);

 create table UserCem
  (
    user_id int(3) not null auto_increment,
    user_data_cadastro date,
    user_email varchar(200),
    user_nome varchar(200),
    user_senha varchar(25),
    CONSTRAINT UserCem_pkey PRIMARY KEY (user_id ),
    CONSTRAINT UserCem_email_key UNIQUE (user_email )
  );

select 'Tabelas criadas com sucesso, \nuse o comando "SHOW TABLES" para visualizar \nas 12 tabelas que foram criadas' AS '';
