CREATE DATABASE masp;

USER masp;

CREATE TABLE artista (
	id int primary key auto_increment,
	nome varchar(50) not null,
	localNasc varchar(50),
	anoNasc date,
	anoMorte date
);

CREATE TABLE categoria (
	id int primary key auto_increment,
	nome varchar(50) not null,
	descricao varchar(200)
);

CREATE TABLE setor (
	id int primary key auto_increment,
	nome varchar(50) not null,
	andar varchar(20) not null
);

CREATE TABLE ingresso (
	id int primary key auto_increment,
	dataVenda date,
	valor float,
	qtde tinyint,
	exposicao int,
	tipoIngresso varchar(10)
);

ALTER TABLE ingresso ADD CONSTRAINT `fk_exposicao` FOREIGN KEY (`exposicao`)REFERENCES `exposicao` (`id`);

CREATE TABLE exposicao (
	id int primary key auto_increment,
	titulo varchar(100),
	dtInicio date,
	dtFim date,
	tema varchar(50),
	descricao varchar(200)
);

CREATE TABLE material (
	id int primary key auto_increment,
	nome varchar(50),
	id_categoria int
);

ALTER TABLE material ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`id_categoria`)REFERENCES `categoria` (`id`);

CREATE TABLE obra (
	id int primary key auto_increment,
	id_artista int,
	nome varchar(50),
	id_categoria int,
	id_material int,
	descricao varchar(200),
	imagem varchar(100),
	dataComposicao date,
	proprietario boolean,
	status varchar(20),
	id_setor int,
	preco float
);

ALTER TABLE obra ADD CONSTRAINT `fk_artista` FOREIGN KEY (`id_artista`)REFERENCES `artista` (`id`);

ALTER TABLE obra ADD CONSTRAINT `fk_categoria_obra` FOREIGN KEY (`id_categoria`)REFERENCES `categoria` (`id`);

ALTER TABLE obra ADD CONSTRAINT `fk_material` FOREIGN KEY (`id_material`)REFERENCES `material` (`id`);

ALTER TABLE obra ADD CONSTRAINT `fk_setor` FOREIGN KEY (`id_setor`)REFERENCES `setor` (`id`);

CREATE TABLE emprestimo (
	id int primary key auto_increment,
	id_obra int,
	destino varchar(100),
	dataInicial date,
	dateFinal date,
	museu varchar(80),
	responsavel varchar(100),
	custo float
);

ALTER TABLE emprestimo ADD CONSTRAINT `fk_obra_emprestimo` FOREIGN KEY (`id_obra`) REFERENCES `obra` (`id`);
	


