package be.technocite.todo.repository.impl;

import be.technocite.todo.model.Todo;
import be.technocite.todo.model.User;
import be.technocite.todo.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public User findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findById(long id) {
        return users.stream()
                .filter(user -> user.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Todo> findAllTodo(User user) {
        return (List<Todo>) findByEmail(user.getEmail()).getTodoList();
    }

    @Override
    public User save(User user) {
        if(findByEmail(user.getEmail()) == null) {
            users.add(user);
        }else {
            users.remove(user);
            users.add(user);
        }

        return findByEmail(user.getEmail());
    }
}
