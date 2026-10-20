CREATE DATABASE clube_livro;
USE clube_livro;

CREATE TABLE Livro
(
	id bigint primary key identity not null,
	titulo varchar(100) not null,
	dono varchar(40),
	estatus varchar(10),
	dataEmprestimo datetime,
	dataDevolucaoPrevista datetime
)