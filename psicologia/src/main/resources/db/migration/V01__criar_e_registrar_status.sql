
CREATE TABLE status(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

insert into status (nome) values ('agendado');
insert into status (nome) values ('atendido');
insert into status (nome) values ('cancelado');
