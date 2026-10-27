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


/*
insert into Livro(titulo, dono, estatus, dataEmprestimo, dataDevolucaoPrevista) values ('Harry Potter e o Cálice de Fogo', 'Geraldo', 'DISPONIVEL', '2026-10-27T08:30:00', '2026-11-05T08:30:00')

*/ 
