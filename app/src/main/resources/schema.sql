-- Single Table Inheritance, lidar com os nulos
CREATE TABLE usuarios (
  tipo          VARCHAR(50), -- aluno, servidor
  -- usuario
  email         VARCHAR(100) PRIMARY KEY,
  senha         TEXT,
  cpf           VARCHAR(11),
  -- aluno
  matricula     VARCHAR(10),
  data_ingresso DATE,
  -- servidor
  siape         INTEGER,
  perfil        VARCHAR(20)
);

CREATE INDEX IF NOT EXISTS ON usuarios (tipo);

-- Class Table Inheritance (Tabler per Class)
CREATE TABLE usuarios (
  email         VARCHAR(100) PRIMARY KEY,
  senha         TEXT
);

CREATE TABLE alunos (
  email         VARCHAR(100) REFERENCES usuarios (email),
  matricula     VARCHAR(10),
  data_ingresso DATE
);

CREATE TABLE servidores (
  email         VARCHAR(100) REFERENCES usuarios (email),
  siape         INTEGER,
  perfil        VARCHAR(20)
);

SELECT s.*, u.senha
FROM servidores s JOIN usuarios u ON u.email = s.email
WHERE s.siape = 112344;

-- Table per Concrete Class (Concrete Table Inheritance)
-- Tabela por Classe Concreta
CREATE TABLE alunos ( -- classe Aluno é concreta
  email         VARCHAR(100) NOT NULL PRIMARY KEY,
  senha         TEXT             NULL,
  matricula     VARCHAR(10)  NOT NULL UNIQUE,
  data_ingresso DATE         NOT NULL
);

CREATE TABLE servidores ( -- classe Servidor é concreta
  email         VARCHAR(100) PRIMARY KEY,
  senha         TEXT,
  siape         INTEGER UNIQUE -- chave candidata,
  perfil        VARCHAR(20)
);