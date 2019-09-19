package be.technocite.todo.repository;

import be.technocite.todo.model.Todo;

import java.util.List;

public interface TodoRepository {

    Todo findById(long id);

    Todo save(Todo todo);

    List<Todo> findAll();
}
