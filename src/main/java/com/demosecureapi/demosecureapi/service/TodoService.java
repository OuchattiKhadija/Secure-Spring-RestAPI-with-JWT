package com.demosecureapi.demosecureapi.service;

import com.demosecureapi.demosecureapi.model.Todo;
import com.demosecureapi.demosecureapi.model.User;
import com.demosecureapi.demosecureapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
}
