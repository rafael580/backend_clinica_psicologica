CREATE TABLE tiposessao(
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       nome VARCHAR(50) NOT NULL
);

insert into tiposessao (nome) values ('individual');
insert into tiposessao (nome) values ('casal');
insert into tiposessao (nome) values ('grupo');
insert into tiposessao (nome) values ('dupla');
