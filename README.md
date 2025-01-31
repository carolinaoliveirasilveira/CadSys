# CadSys

O projeto **CadSys** é uma aplicação full stack simples, porém bem estruturada e segura. Desenvolvi esse sistema de cadastro com o objetivo de explorar conceitos fundamentais, como HTML, CSS, protocolo HTTP, JSON, JavaScript e banco de dados MySQL. Além disso, aprofundei meus conhecimentos em Spring Security, JWT (JSON Web Token), CORS e Filtros de Autenticação Personalizados, com foco em proporcionar uma autenticação segura e um controle de acesso eficiente na API.


# Tecnologias utilizadas

- **[Spring Boot](https://spring.io/projects/spring-boot):** Framework que simplifica o desenvolvimento de aplicações Java, oferecendo configuração automática, servidor embutido e um ecossistema robusto para criação de APIs.

- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa):** Abstração para operações de banco de dados utilizando JPA.

- **[MySql](https://www.mysql.com/):** Sistema de gerenciamento de banco de dados relacional (RDBMS) usado para armazenar e gerenciar os dados da aplicação de forma segura e escalável.

- **[Insomnia](https://insomnia.rest/download):** Utilizado para testar APIs REST, permitindo enviar requisições, visualizar respostas e simular interações com a aplicação.

## Instalação da aplicação

1. Primeiramente, faça o clone do repositório:
   ```bash
   git clone https://github.com/carolinaoliveirasilveira/CadSys
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd cadsys
   ```
3. Compile o código e baixe as dependências do projeto:
   ```bash
   mvn clean package
   ```
4. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

---
# APIs Disponíveis

O projeto disponibiliza algumas APIs: **Login**, **Delete**, **Change**, **list** e **create**. Todas as APIs seguem o padrão REST, produzindo e consumindo dados no formato JSON.
