CREATE DATABASE agencia_viagens;

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
	dt_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE destinos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    localizacao VARCHAR(200) NOT NULL,
    descricao TEXT,
    nota_media DOUBLE PRECISION DEFAULT 0,
    quantidade_avaliacoes INTEGER DEFAULT 0,
	dt_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);



INSERT INTO usuarios
(username, password, role)
VALUES
(
    'admin',
    '$2a$10$RdR.nbYLuekRIsqH4KldieTSIxoOXBuG0zIzas9xCruJE1DteFF3O',
    'ADMIN'
);

INSERT INTO usuarios
(username, password, role)
VALUES
(
    'usuario1',
    '$2a$12$FCE5x6W/6NmJmmh3ZfLi4elueMaRLERUdCYytpFwGI0VfQuZ4RAg2',
    'USER'
);




