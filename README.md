# GameReview
# 🎮 GameReview API

A **GameReview** é uma API REST desenvolvida em **Spring Boot** com banco de dados **PostgreSQL** (via Docker), voltada para gerenciamento de avaliações de jogos. O projeto realiza operações CRUD para **jogos**, **desenvolvedoras** e **avaliações**, com foco em boas práticas de arquitetura e segurança de dados, utilizando DTOs, JPA/Hibernate e Swagger para documentação.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.3
- Spring Web & WebFlux
- Spring Data JPA
- PostgreSQL (Docker)
- Flyway (versionamento de banco de dados)
- Lombok
- SpringDoc OpenAPI (Swagger)
- DBeaver (administração do banco)
- Docker & Docker Compose

---

## 📦 Funcionalidades da API

### 📁 Jogos
- **POST /games** – Criação de um novo jogo
- **GET /games** – Listagem de todos os jogos
- **GET /games/{id}** – Detalhes de um jogo específico
- **PUT /games/{id}** – Atualização de dados de um jogo
- **DELETE /games/{id}** – Remoção de um jogo

### 🏢 Desenvolvedoras
- **POST /developers** – Criação de uma desenvolvedora
- **GET /developers** – Listagem de todas as desenvolvedoras
- **PUT /developers/{id}** – Atualização de uma desenvolvedora
- **DELETE /developers/{id}** – Remoção de uma desenvolvedora

### 📝 Avaliações
- **POST /reviews** – Criação de uma avaliação para um jogo
- **GET /reviews** – Listagem de todas as avaliações
- **PUT /reviews/{id}** – Atualização de uma avaliação
- **DELETE /reviews/{id}** – Remoção de uma avaliação

---

## 🛠️ Como Rodar Localmente

### Pré-requisitos

- Java 21+
- Maven
- Docker + Docker Compose

### Passos

1. **Clone o repositório**
   ```bash
   git clone https://github.com/RyanGTorres/GameReview.git
   cd GameReview

2. **Suba o banco de dados PostgreSQL com Docker**
   ```bash
   docker-compose up -d
3. **Rode a aplicação**
   ```bash
   ./mvnw spring-boot:run
---

## 📁 Organização do Projeto
   
src/ <br>
├── main/ <br>
│   ├── java/com/gamereview/<br>
│   │   ├── controller/       Endpoints da API<br>
│   │   ├── dto/              Objetos de transferência de dados<br>
│   │   ├── mapper/           Conversão entre DTOs e Models <br>
│   │   ├── model/            Entidades JPA<br>
│   │   ├── repository/       Interfaces JPA Repository<br>
│   │   ├── service/          Lógica de negócio<br>
│   │   └── GameReviewAppplication.java # Classe principal<br>

---
## 🧠 Objetivos do Projeto
Este projeto foi desenvolvido como parte do meu portfólio, com o intuito de aplicar e demonstrar conhecimentos em:

Desenvolvimento de APIs REST com Spring Boot

Integração com banco de dados via JPA/Hibernate

Uso de Flyway para versionamento

Boas práticas com DTOs, ResponseEntity e separação em camadas

Containers Docker para ambiente de desenvolvimento

