package be.technocite.todo.repository;

import be.technocite.todo.model.Todo;
import be.technocite.todo.model.User;

import java.util.List;

public interface UserRepository {

    User findByEmail(String email);

    List<Todo> findAllTodo(User user);
}
