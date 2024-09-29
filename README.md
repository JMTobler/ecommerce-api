# E-commerce API
Este projeto é uma API RESTful desenvolvida em Java com Spring Boot para gerenciar um sistema de e-commerce. A API oferece funcionalidades completas de CRUD para produtos, categorias e clientes, além de permitir a associação de clientes a múltiplos endereços e produtos a categorias.

## Funcionalidades
- CRUD de Produtos: Criar, Listar, Atualizar e Excluir produtos.
- CRUD de Categorias: Criar, Listar, Atualizar e Excluir categorias.
- CRUD de Clientes: Criar, Listar, Atualizar e Excluir clientes, com suporte a múltiplos endereços.
- Associação de Produtos e Categorias: Consultar produtos vinculados a uma categoria.
- Consulta de Produtos por ID: Buscar um produto pelo seu identificador.

## Pré-requisitos
Para executar este projeto localmente, você precisa ter:

- Java 17 ou superior.
- Maven (para gerenciamento de dependências).
- PostgreSQL ou outro banco de dados configurado no application.properties.
- IDE com suporte a Java (IntelliJ, Eclipse, VSCode, etc.).
- Configuração do Ambiente
- Clone este repositório:

## Configuração do Ambiente
1. Clone este repositório:
```
git clone https://github.com/usuario/ecommerce-api.git
cd ecommerce-api 
```
2. Configure as dependências do Maven:
``
mvn clean install
``

3. Configure o banco de dados no arquivo ``src/main/resources/application.properties``:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
4. Certifique-se de que o banco de dados PostgreSQL está rodando e crie o banco de dados ecommerce:

## Executando o Projeto
Para iniciar a aplicação, use o seguinte comando no diretório do projeto:
```
mvn spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.

## Endpoints da API
# Produtos
- GET ``/api/produto``: Lista todos os produtos.
- POST ``/api/produto``: Cria um novo produto.
- GET ``/api/produto/{id}``: Consulta um produto pelo ID.
- PUT ``/api/produto/{id}``: Atualiza um produto existente.
- DELETE ``/api/produto/{id}``: Exclui um produto pelo ID.

# Categorias
- GET ``/api/categoria``: Lista todas as categorias.
- POST ``/api/categoria``: Cria uma nova categoria.
- GET ``/api/categoria/{id}``: Consulta uma categoria pelo ID.
- PUT ``/api/categoria/{id}``: Atualiza uma categoria existente.
- DELETE ``/api/categoria/{id}``: Exclui uma categoria pelo ID.
- GET ``/api/categoria/{id}/produto``: Lista todos os produtos de uma categoria.

# Clientes
- GET ``/api/clientes``: Lista todos os clientes.
- POST ``/api/clientes``: Cria um novo cliente com múltiplos endereços.
- GET ``/api/clientes/{id}``: Consulta um cliente pelo ID.
- PUT ``/api/clientes/{id}``: Atualiza um cliente existente.
- DELETE ``/api/clientes/{id}``: Exclui um cliente pelo ID.

## Testando a API
Você pode testar os endpoints da API usando:

- Postman ou Insomnia para enviar requisições HTTP.
- Arquivo .http para testar diretamente na sua IDE (exemplo abaixo).

# Exemplo de Requisição
Use o arquivo .http para testar via IDE (VSCode com extensão REST Client ou IntelliJ).

## Estrutura do Projeto
- Controllers: Controladores que gerenciam as requisições HTTP.
- Services: Camada de serviço responsável pela lógica de negócios.
- Repositories: Interface com o banco de dados.
- Models: Entidades que representam as tabelas do banco de dados.
