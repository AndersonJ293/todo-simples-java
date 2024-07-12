package com.andersonjr.desafiotodolist.controller;

import com.andersonjr.desafiotodolist.entity.ToDo;
import com.andersonjr.desafiotodolist.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
  private final ToDoService toDoService;

  public ToDoController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  @PostMapping
  public ResponseEntity<List<ToDo>> create(@RequestBody @Valid ToDo todo) {
    return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(todo));
  }

  @GetMapping
  public ResponseEntity<List<ToDo>> list() {
    return ResponseEntity.status(HttpStatus.OK).body(toDoService.list());
  }

  @PutMapping("{id}")
  public ResponseEntity<List<ToDo>> update(@PathVariable(value = "id") Long id, @RequestBody ToDo toDo) {
    toDo.setId(id);
    return ResponseEntity.status(HttpStatus.OK).body(toDoService.update(toDo));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
    toDoService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("ToDo deleted.");
  }

  @GetMapping("{id}")
  public ResponseEntity<ToDo> getById(@PathVariable(value = "id") Long id) {
    ToDo toDo = toDoService.getById(id);

    if (toDo == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    return ResponseEntity.status(HttpStatus.OK).body(toDo);
  }
}
