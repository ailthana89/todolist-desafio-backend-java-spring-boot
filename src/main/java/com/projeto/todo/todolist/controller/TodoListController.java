package com.projeto.todo.todolist.controller;

import com.projeto.todo.todolist.entity.TodoList;
import com.projeto.todo.todolist.service.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoListController {
    public TodoListService service;
    public TodoListController(TodoListService service) {
        this.service = service;
    }
    @PostMapping
    public List<TodoList> created(TodoList todoList) {
        return service.created(todoList);
    }
    @GetMapping
    public List<TodoList> list(TodoList todoList) {
        return service.list();
    }
    @PutMapping
    public List<TodoList> update(@RequestBody TodoList todoList) {
        return service.update(todoList);
    }
    @DeleteMapping("/{id}")
    public List<TodoList> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
