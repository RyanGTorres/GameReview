# GameReview API 🎮

## Sobre o Projeto

GameReview é uma API desenvolvida para gerenciar avaliações de jogos, permitindo que usuários compartilhem suas experiências e opiniões sobre diferentes títulos de jogos. O projeto foi construído utilizando Spring Boot e segue as melhores práticas de desenvolvimento de APIs RESTful.

## Tecnologias Utilizadas 🛠️

- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**
- **Flyway** (Migração de banco de dados)
- **MapStruct** (Mapeamento de objetos)
- **Lombok** (Redução de boilerplate)
- **SpringDoc OpenAPI** (Documentação da API)
- **Thymeleaf** (Template engine)

## Pré-requisitos 📋

- Java 21
- Docker e Docker Compose
- Maven
- IDE de sua preferência (recomendado: IntelliJ IDEA)

## Configuração do Ambiente 🔧

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/RyanGTorres/GameReview
   cd GameReview
   ```

2. **Configure as variáveis de ambiente:**
   Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:
   ```env
   DATABASE_DB=nome_do_banco
   DATABASE_USERNAME=seu_usuario
   DATABASE_PASSWORD=sua_senha
   ```

3. **Inicie o banco de dados com Docker:**
   ```bash
   docker-compose up -d
   ```

4. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

## Estrutura do Projeto 📁

O projeto segue uma arquitetura em camadas:

- **Controllers**: Endpoints da API
- **Services**: Lógica de negócios
- **Repositories**: Acesso ao banco de dados
- **Models**: Entidades e DTOs
- **Mappers**: Conversão entre entidades e DTOs
- **Config**: Configurações do Spring Boot

## Documentação da API 📚

A documentação da API está disponível através do Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

## Endpoints Principais 🌐

- `GET /api/games`: Lista todos os jogos
- `POST /api/games`: Cadastra um novo jogo
- `GET /api/reviews`: Lista todas as avaliações
- `POST /api/reviews`: Cadastra uma nova avaliação
- `GET /api/games/{id}/reviews`: Lista avaliações de um jogo específico

## Banco de Dados 💾

O projeto utiliza PostgreSQL como banco de dados principal, com as seguintes configurações:

- **Porta**: 5438 (mapeada para 5432 no container)
- **Migrations**: Gerenciadas pelo Flyway
- **Modelo**: JPA/Hibernate

## Desenvolvimento 👨‍💻

Para contribuir com o projeto:

1. Crie uma branch para sua feature
2. Faça suas alterações
3. Execute os testes
4. Envie um Pull Request

## Build e Deployment 🚀

Para criar um build do projeto:
```bash
./mvnw clean package
```

O arquivo JAR será gerado na pasta `target/`.

## Testes ✅

Execute os testes com:
```bash
./mvnw test
```



