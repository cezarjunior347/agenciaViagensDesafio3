# API Agência de Viagens

Projeto desenvolvido para a disciplina de Desenvolvimento de Sistemas Web.

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven

## Funcionalidades

* Cadastrar destinos de viagem
* Listar destinos
* Pesquisar destinos
* Consultar destino por ID
* Avaliar destinos
* Atualizar destinos
* Excluir destinos

## Perfis de Usuário

### ADMIN

Possui acesso completo à API.

### USER

Pode consultar e avaliar destinos.

## Usuários para Teste

### ADMIN

Usuário: `admin`

Senha: `123456`

### USER

Usuário: `usuario1`

Senha: `654321`

## Banco de Dados

Antes de executar a aplicação:

1. Crie o banco PostgreSQL com o nome:

agencia_viagens

2. Execute o script:

database/schema.sql

Observação:

Caso sua instalação do PostgreSQL utilize credenciais diferentes, ajuste os valores de `username` e `password` no arquivo:

src/main/resources/application.properties

## Executando o Projeto

Compilar:

mvn clean compile


Executar:

mvn spring-boot:run

## Autor

Cezar Barroso Pinto Junior
