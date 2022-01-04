package com.demosecureapi.demosecureapi.controller;

import com.demosecureapi.demosecureapi.model.Todo;
import com.demosecureapi.demosecureapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// https://www.youtube.com/watch?v=B03UruvOl30

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        Todo todo1 = todoService.createTodo(todo);
        if (todo1 == null){
            return new ResponseEntity<>(todo1, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        List<Todo> todo1 = todoService.getTodos();
        if (todo1 == null){
            return new ResponseEntity<>(todo1,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todo1, HttpStatus.OK);
    }
}
