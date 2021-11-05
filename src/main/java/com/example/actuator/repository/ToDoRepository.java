package com.example.actuator.repository;

import com.example.actuator.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, String> {
    long countByCompleted(Boolean completed);
}
