# CRUD de Livros

## O que é a Aplicação

Essa é uma aplicação de CRUD básico em que consiste em manipular dados no banco através da entidade Book.

##	Funcionalidades

- Encontra um Livro registrado no sistema por ID.

- Encontra uma lista de Livros registrados no sistema.

- Registra um Livro no sistema.

- Atualiza dados de um Livro do sistema.

- Deleta um Livro do sistema.

## Versionamento 

  Versão do Java: 17

  Versão do Spring Boot: 3.0.6
  
## Tecnologias Utilizadas

Back end

- Java :heavy_check_mark:

- Spring Data JPA :heavy_check_mark:

- Maven :heavy_check_mark:

## SCHEMA

![book schema](https://github.com/dsaoDev/book-spring/assets/129787872/42575cbc-094e-4601-a41e-2bac8124cd79)

## Dependencias do Maven

Data JPA - > Utilizando o JPA para fazer a ponte entre o banco de dados e a aplicação -> ORM

Spring Web -> É uma aplicação WEB, Utilizado para receber requisições, devolver uma resposta ...

LomBok -> Utilizado para evitar muitas linhas de código através de annotations.

MySQL Connector -> Utilizado para se connectar ao Banco de Dados MySQL

## Programas Utilizados
Postman - Utilizado para fazer as requisições (CONSUMIR) a aplicação.

STS- IDE escolhida para desenvolver o projeto.

MySQL -> Utilizado esse BANCO no ambiente de desenvolvimento e produção.

MySQL WorkBench - Plataforma utilizada para fazer a manipulação e a leitura dos dados de uma base de dados do banco MySQL.

Git e GitHub - Utilizados para commitar o projeto e subir o código para a nuvem(remoto). 

## Como Executar o Projeto
### Pré Requisitos: JAVA 17 e MySQL database

```bash
# clonar repositorio
git clone https://github.com/dsaoDev/book-spring.git

# entrar na pasta do projeto
cd book-crud-spring

# executar o projeto
./mvnw spring-boot:run
```
