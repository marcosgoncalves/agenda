DROP table IF EXISTS contato;
CREATE TABLE contato (
    id int(11) NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    endereco varchar(100) DEFAULT NULL,
    telefone varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);