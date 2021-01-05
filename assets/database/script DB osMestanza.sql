-- A linha abaixo mostra todas as bases de dados existentes
SHOW DATABASES;
-- A linha abaixo cria uma base de dados
CREATE DATABASE dbosmestanza;
-- A linha abaixo escolhe o banco de dados a ser utilizado
USE dbosmestanza;
-- O bloco de instrucoes abaixo cria uma tabela, seguem todas as criadas para uso do OS Mestanza
CREATE TABLE tbl_Usuarios (
ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
Nome_Usuario VARCHAR(25) NOT NULL,
Fone_Usuario VARCHAR(17),
Login_Usuario VARCHAR(20) NOT NULL UNIQUE,
Senha_Usuario VARCHAR(20) NOT NULL,
Perfil_Usuario VARCHAR(13) NOT NULL
);
CREATE TABLE tbl_Clientes (
ID_Cliente INT PRIMARY KEY AUTO_INCREMENT,
Nome_Cliente VARCHAR(25) NOT NULL,
Fone_Cliente VARCHAR(17),
CPF_Cliente VARCHAR(14),
Endereco_Cliente VARCHAR(100)
);
CREATE TABLE tbl_OS(
ID_OS INT PRIMARY KEY AUTO_INCREMENT,
Data_OS TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
Tipo_OS VARCHAR(9) NOT NULL,
Situacao_OS VARCHAR(23) NOT NULL,
Equipamento_OS VARCHAR(50) NOT NULL,
Defeito_OS VARCHAR(50) NOT NULL,
Servico_OS VARCHAR(50),
Tecnico_OS VARCHAR(20),
Valor_OS DECIMAL(10,2),
ID_Cliente INT NOT NULL,
FOREIGN KEY(ID_Cliente) REFERENCES tbl_Clientes(ID_Cliente)
);
-- O comando abaixo descreve a tabela, mostra seus campos e atributos deles
DESCRIBE tbl_OS;
-- A linha abaixo insere dados na tabela (CRUD), create - Insert
INSERT INTO tbl_Usuarios(Nome_Usuario, Fone_Usuario, Login_Usuario, Senha_Usuario, Perfil_Usuario) VALUES('Usuario', '12912345678', 'user', 'Senha123', 'Administrador');
-- A linhas abaixo exibem os dados da tabela (CRUD), read - Select
SELECT * FROM tbl_Usuarios;
-- A linha abaixo consulta a tabela usando um filtro
SELECT * FROM tbl_Usuarios WHERE Nome_Usuario LIKE '%';
-- As linhas abaixo realizam buscas simultaneas em duas tabelas
SELECT tbl_Clientes.Nome_Cliente AS Nome, tbl_OS.ID_OS AS OS, tbl_OS.Data_OS AS Data FROM tbl_Clientes, tbl_OS WHERE tbl_Clientes.ID_Cliente = tbl_OS.ID_Cliente AND tbl_Clientes.Nome_Cliente LIKE "%";
SELECT tbl_Clientes.Nome_Cliente, tbl_OS.Data_OS, tbl_OS.Tipo_OS, tbl_OS.Situacao_OS, tbl_OS.Equipamento_OS, tbl_OS.Defeito_OS, tbl_OS.Servico_OS, tbl_OS.Tecnico_OS, tbl_OS.Valor_OS FROM tbl_Clientes, tbl_OS WHERE tbl_Clientes.ID_cliente = tbl_OS.ID_cliente AND tbl_OS.ID_OS = 1;
-- A linha abaixo realiza uma busca por IDs de forma decrescente
SELECT ID_OS FROM tbL_OS ORDER BY ID_OS DESC LIMIT 1;
-- A linha abaixo realiza uma busca por ordem dos nomes dos clientes
SELECT * FROM tbl_Clientes ORDER BY Nome_Cliente;
-- A linha abaixo modifica dados na tabela (CRUD), update - Update
UPDATE tbl_Usuarios SET Fone_Usuario='12 4002-8922' WHERE ID_Usuario=?;
-- A linha abaixo apaga um registro da tabela (CRUD), delete - Delete
DELETE FROM tbl_Usuarios WHERE ID_Usuario =?;
-- O codigo abaixo traz informacoes de duas tabelas, através de um relacionamento
SELECT O.ID_OS, Equipamento_OS, Defeito_OS, Servico_OS, Valor_OS, C.Nome_Cliente, Fone_Cliente FROM tbl_OS AS O INNER JOIN tbl_Clientes AS C ON (O.ID_Cliente = C.ID_Cliente);
-- A linha abaixo adiciona uma coluna a uma tabela
ALTER TABLE tbl_Usuarios ADD COLUMN Perfil_Usuario VARCHAR(5) NOT NULL;
-- A linha abaixo adiciona uma campo a uma tabela
ALTER TABLE tbl_OS ADD Situacao_OS VARCHAR(20) NOT NULL AFTER Tipo_OS;
-- A linha abaixo remove uma coluna de uma tabela
ALTER TABLE tbl_Usuarios DROP COLUMN Perfil_Usuarios;
-- A linha abaixo renomeia um campo de uma tabela
ALTER TABLE tbl_OS CHANGE Tipo Tipo_OS VARCHAR(30);
-- A linha abaixo deleta uma tabela
DROP TABLE tbos;