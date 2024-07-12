package com.andersonjr.desafiotodolist.service;

import com.andersonjr.desafiotodolist.entity.ToDo;
import com.andersonjr.desafiotodolist.repository.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
  private final ToDoRepository toDoRepository;

  public ToDoService(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  public List<ToDo> create(ToDo toDo) {
    toDoRepository.save(toDo);
    return list();
  }

  public List<ToDo> list() {
    Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
    return toDoRepository.findAll(sort);
  }

  public List<ToDo> update(ToDo toDo) {
    toDoRepository.save(toDo);
    return list();
  }

  public void delete(Long id) {
    toDoRepository.deleteById(id);
  }

  public ToDo getById(Long id) {
    return toDoRepository.findById(id).orElse(null);
  }
}
