## Desafio Dock Tech de Seleção

### Instruções para a execução do projeto

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java 11**
- **Maven**
- **Spring Boot**
- **Docker**
- **PostgreSQL**

Para facilitar o processo de desenvolvimento, a ferramenta **Docker** foi utilizada para ajudar na construção do ambiente.
Portanto, podemos iniciar a execução da aplicação, executando o seguinte comando a partir da linha de comando:

- **docker-compose up -d**

Após sua execução, nós teremos de pé dois containers:

1. springboot-postgresql - container que contém a aplicação em execução.
2. postgresql - container que contém o banco de dados da aplicação em execução.

Obs.: nesse caso não serão executados os testes implementados.

### Instruções para a execução dos testes

Caso queira analisar a execução dos testes, basta executar o seguinte comando a partir da linha de comando:

- **mvn clean package**

e depois executar o comando do docker compose descrito acima para executar a aplicação.

### Documentação

A aplicação utiliza o **Swagger** como forma de documentação, além do **Javadoc**.
Portanto, após subir a aplicação, será disponibilizada a seguinte url para uso da aplicação:

- **http://localhost:8080/swagger-ui/index.html#/**

Nessa interface será possível usar os recursos de Contas e Transações.

### Script de banco de dados

Ao iniciar a aplicação, a base de dados será totalmente semeada com informações para ajudar no uso da aplicação.
A base de dados será automaticamente criada pelo **Docker**.
