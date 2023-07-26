package com.projeto.todo.todolist.service;

import com.projeto.todo.todolist.entity.TodoList;
import com.projeto.todo.todolist.repository.TodoListRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository repository;

    public TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }


    public List<TodoList> created(TodoList todo) {
        repository.save(todo);
        return list();
    }
    public List<TodoList> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return repository.findAll();
    }
    public List<TodoList> update(TodoList todo) {
        repository.save(todo);
        return list();

    }
    public List<TodoList> delete(Long id) {
        repository.deleteById(id);
        return list();
    }

}
