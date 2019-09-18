package be.technocite.todo.repository;

import be.technocite.todo.model.Todo;

public interface TodoRepository {

    Todo findById(long id);

    Todo save(Todo todo);
}
