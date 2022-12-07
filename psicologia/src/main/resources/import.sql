USE db_psicologia;

insert into status (nome) values ('agendado');
insert into status (nome) values ('atendido');
insert into status (nome) values ('cancelado');

insert into tiposessao (nome) values ('individual');
insert into tiposessao (nome) values ('casal');
insert into tiposessao (nome) values ('grupo');
insert into tiposessao (nome) values ('dupla');

insert into  genero (nome) values  ('masculino');
insert into  genero (nome) values  ('feminino');


insert into sessao (duracao) values ("00-20");

insert into paciente (nome) values ("porto alehre");

insert into tb_paciente_sessao (paciente_id, sessao_id) values (1,1);
insert into tb_paciente_sessao (paciente_id, sessao_id) values (1,2);