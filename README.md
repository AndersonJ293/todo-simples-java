# <center>TODO List</center>

---

#### Api para gerenciar tarefas (Crud) criada para estudar o funcionamento de API's RESTFUL no Java.

## Tecnologias:
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring MVC](https://spring.io/guides/gs/serving-web-content)
* [Spring JPA](https://spring.io/guides/gs/serving-web-content)
* [SpringDoc OpenAPI 3](https://springdoc.org/)
* [PostgreSql](https://www.postgresql.org/)

### Praticas Adotadas:
* SOLID, DRY, YAGNI, KISS
* API REST
* Consultas com Spring Data JPA
* Injeção de Dependências
* Tratamento de respostas de erro
* Geração automática do Swagger com a OpenAPI 3

### Como Executar
* Clonar repositório git
* Construir o projeto:
```
* $./mvnw clean package
```
* Executar a aplicação:
```
$ java-jar target/todolist-0.0.1-SNAPSHOT.jar
```
A API poderá ser acessada em [localhost:8080](http://localhost:8080). O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/):
* Criar Todo
```
POST https://localhost/8080/todos

body {
    {
        "description":"Desc Todo 1",
        "name":"Todo 1",
        "priority":1,
        "completed":false
    }
}

Response {
    [
        {
            "id":1,
            "description":"Desc Todo 1",
            "name":"Todo 1",
            "priority":1,
            "completed":false,
            "created_at":"2024-07-12T00:33:58.065Z"
        }
    ]
}
```

* Listar Todos
```
GET https://localhost/8080/todos

Response {
    [
        {
            "id":1,
            "description":"Desc Todo 1",
            "name":"Todo 1",
            "priority":1,
            "completed":false,
            "created_at":"2024-07-12T00:33:58.065Z"
        },
        {
            "id":2,
            "description":"Desc Todo 2",
            "name":"Todo 2",
            "priority":1,
            "completed":false,
            "created_at":"2024-07-12T00:33:58.065Z"
        }
    ]
}
```

* Listar Todo por ID
```
GET https://localhost/8080/todos/1

Response {
    {
        "id":1,
        "description":"Desc Todo 1",
        "name":"Todo 1",
        "priority":1,
        "completed":false,
        "created_at":"2024-07-12T00:33:58.065Z"
    }
}
```

* Atualizar Todo
```
PUT https://localhost/8080/todos/1

Body {
    {
        "description":"Desc Todo Atualizada",
        "name":"Todo Atualizada",
        "priority":5,
        "completed":true
    }
}

Response {
    [
        {
            "id":1,
            "description":"Desc Todo Atualizada",
            "name":"Todo Atualizada",
            "priority":5,
            "completed":true,
            "created_at":"2024-07-12T00:33:58.065Z"
        }
    ]
}
```

* Atualizar Todo
```
DELETE https://localhost/8080/todos/1

Response {
    [ ]
}
```