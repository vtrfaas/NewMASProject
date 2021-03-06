CREATE DATABASE masp;

USE masp;

CREATE TABLE artista (
	id int primary key auto_increment,
	nome varchar(50) not null,
	localNasc varchar(50),
	anoNasc date,
	anoMorte date
);

INSERT INTO artista VALUES (1, 'Vincent Van Gogh', 'Zundert, Netherlands', '1853/03/30', '1890/07/29');
INSERT INTO artista VALUES (2, 'Leonardo di ser Piero da Vinci', 'Vinci, Republic of Florence', '1452/04/15', '1519/05/02');

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

INSERT INTO setor (id, nome, andar) VALUES (1, 'Renascimento', 1);

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

ALTER TABLE exposicao ADD COLUMN valor float;

INSERT INTO exposicao (titulo, dtInicio, dtFim, tema, descricao) VALUES ('Segunda Guerra Mundial', '2016/06/24', '2016/06/30', 'Veiculos da Segunda Guerra Mundial', 'Transportes utilizados durante o periodo de 1939 a 1945');

CREATE TABLE exposicao_obra (
	id_obra int,
	id_exposicao int
);

ALTER TABLE exposicao_obra ADD CONSTRAINT `fk_exposicao_obra` FOREIGN KEY (`id_obra`)REFERENCES `obra` (`id`);
ALTER TABLE exposicao_obra ADD CONSTRAINT `fk_exposicao_obra_exp` FOREIGN KEY (`id_exposicao`)REFERENCES `exposicao` (`id`);

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

ALTER TABLE obra MODIFY imagem varchar(400);

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
	


