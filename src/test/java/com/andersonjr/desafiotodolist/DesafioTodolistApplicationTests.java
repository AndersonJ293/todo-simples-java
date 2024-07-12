package com.andersonjr.desafiotodolist;

import com.andersonjr.desafiotodolist.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DesafioTodolistApplicationTests {
  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testCreateTodoSuccess() {
    var todo = new ToDo("todo 1", "desc todo 1", false, 1);
    webTestClient.post()
            .uri("/todos")
            .bodyValue(todo)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody()
            .jsonPath("$")
            .isArray()
            .jsonPath("$.length()")
            .isEqualTo(1)
            .jsonPath("$[0].name").isEqualTo(todo.getName())
            .jsonPath("$[0].description").isEqualTo(todo.getDescription())
            .jsonPath("$[0].priority").isEqualTo(todo.getPriority())
            .jsonPath("$[0].completed").isEqualTo(todo.isCompleted());
  }

  @Test
  void testCreateTodoFailure() {
    webTestClient.post()
            .uri("/todos")
            .bodyValue(new ToDo("", "", false, 0))
            .exchange()
            .expectStatus()
            .isBadRequest();
  }

}
