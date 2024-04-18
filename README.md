# aula-05-persistence-configuration

```sql
CREATE TABLE alunos (
    VARCHAR matricula,
    DATE dataIngresso
)
```

Object
Relational
Mapping

Modelos
OO       <-> Relacional
Classe   <-> Tabela (entidade)
Objeto   <-> Registro (tupla)
Atributo <-> Coluna (campo)

camelCase (lowerCamelCase)
CamelCase (UpperCamelCase ou PascalCase)
kebab-case
snake_case
notação húngara (codificar metadados no nome)
const btSalvar = document.querySelect('button.salvar')

```java
class Aluno {
  long id;
  String nome;
  LocalDateTime dataCadastro;
```

```sql
CREATE TABLE alunos (
  INTEGER      id            NOT NULL PRIMARY KEY,
  VARCHAR(100) nome          NOT NULL,
  TIMESTAMP    data_cadastro NOT NULL
);
```
