package org.example.todoapispring.controllers;

import org.example.todoapispring.exceptions.NotFoundException;
import org.example.todoapispring.pojo.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todosList;

    public TodoController() {
        todosList = new ArrayList<>();
        todosList.add(new Todo(1, false, "Todo 1", 1));
        todosList.add(new Todo(2, true, "Todo 2", 2));
    }

    @GetMapping()
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok(todosList);
    }

    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED) // to set the status code
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        todosList.add(todo);
//        return todo;
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @GetMapping("/{todosId}")
    public  ResponseEntity<Todo> getTodoById(@PathVariable Long todosId) throws NotFoundException {
        try {
            for (Todo todo : todosList) {
                if (todo.getId() == todosId) {
                    return ResponseEntity.ok(todo);
                } else {
                    throw new NotFoundException("resource Not found ");
                }
            }
        }catch(NotFoundException e){
//            return "Resource not found";
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        return new ResponseEntity<>("Comment Not found", HttpStatus.NOT_FOUND);
    }




}
