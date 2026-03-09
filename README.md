# 💻 Workshop Java Spring Boot com JPA/Hibernate & PostgreSQL

Projeto desenvolvido como parte de um **workshop completo de Spring Boot**, com o objetivo de praticar e demonstrar uma aplicação **backend**, contendo entities, relacionamentos e operações típicas de um sistema de pedidos.

**---**

## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Maven&logoColor=white)

This project is an API built using **Java, Java Spring, JPA/Hibernate, PostgresSQL as the database.**
---

## Content/Conteúdos

- [Objetivo do Projeto](#-objetivo-do-projeto--objective)
- [Perfis de Aplicação](#-perfis-de-aplicação--profile-application)
- [Database](#database)
- [Como Executar](#%EF%B8%8F-como-executar)
- [API Endpoints](#api-endpoints)
- [Deploy](#deploy)


## 💡 Objetivo do Projeto / Objective

Este projeto simula uma aplicação de **loja virtual** (e-commerce) para gerenciar produtos, pedidos, usuários e categorias.

Ele foi construído do zero, integrando **camadas de domínio, repositórios, serviços e controladores RESTful**, permitindo operações CRUD completas com persistência em banco de dados.

A aplicação foi organizada seguindo boas práticas de arquitetura em camadas!

**---**

This project simulates an online store (e-commerce) application for managing products, orders, users, and categories.

It was built from scratch, integrating domain layers, repositories, services, and RESTful controllers, allowing for complete CRUD operations with database persistence.

The application was organized following best practices in layered architecture!

**---**

## 🧪 Perfis de Aplicação / Profile application

O projeto possui dois perfis configurados no **application.properties**:

test → usa banco H2 em memória

dev / prod → usa **PostgreSQL** ou SGBD de sua preferência.

## Database

Exemplo de configuração **PostgreSQL**

3. Instalar o [PostgresSQL](https://www.postgresql.org/)

```Java
spring.datasource.url=jdbc:postgresql://localhost:5432/seu-projeto
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## ▶️ Como Executar

### 1️⃣ Clonar o repositório:
``` bash
git clone https://github.com/SeuUsuario/nome-do-repositorio.git
```
### 2️⃣ Entrar na pasta do projeto
``` bash
cd nome-do-repositorio
```
### 3️⃣ Rodar com Maven
```bash
./mvnw spring-boot:run
```
### ou via IDE (Eclipse / IntelliJ) executando a classe:
```java
ProjectApplication.java
```
### 4️⃣ Acessar o H2 Console (modo teste)
```bash
http://localhost:8080/h2-console
```

## API Endpoints
The API provides the following endpoints/ A API fornece os seguintes Endpoints:

```markdown
GET /product - Retrieve a list of all products.

POST /product - Register a new product.

PUT /product/{/id} - Update a product already created.

GET /users - Retrieve a list of all users.

POST /users -  Register a new user.

PUT /users/{/id} - Update some user info already created.
 
```

## Deploy

O projeto foi adaptado para funcionar também com [PostgresSQL](https://www.postgresql.org/) e pode ser facilmente implantado em plataformas como Render, Railway ou Heroku.

