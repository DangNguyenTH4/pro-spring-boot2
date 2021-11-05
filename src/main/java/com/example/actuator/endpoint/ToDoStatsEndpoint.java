package com.example.actuator.endpoint;

import com.example.actuator.dto.Operation;
import com.example.actuator.dto.Stats;
import com.example.actuator.entity.ToDo;
import com.example.actuator.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "todo-stats")
@AllArgsConstructor
public class ToDoStatsEndpoint {
    private final ToDoRepository toDoRepository;

    @ReadOperation
    public Stats stats(){
        return new Stats(toDoRepository.count(), toDoRepository.countByCompleted(true));
    }
    @ReadOperation
    public ToDo getTodo(@Selector String id){
        return this.toDoRepository.findById(id).orElse(null);
    }
    @WriteOperation
    public Operation completeTodo(@Selector String id){
        ToDo todo = toDoRepository.findById(id).orElse(null);
        if(null!=todo){
            todo.setCompleted(true);
            toDoRepository.save(todo);
            return new Operation("COMPLETED", true);
        }else{
            return new Operation("COMPLETED",false);
        }
    }
    @DeleteOperation
    public Operation removeTodo(@Selector String id){
        try{
            this.toDoRepository.deleteById(id);
            return new Operation("DELETED", true);
        }catch(Exception ex){
            return new Operation("DELETED", false);
        }
    }

}
