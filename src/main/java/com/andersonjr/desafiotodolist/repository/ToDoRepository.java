package com.andersonjr.desafiotodolist.repository;

import com.andersonjr.desafiotodolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
