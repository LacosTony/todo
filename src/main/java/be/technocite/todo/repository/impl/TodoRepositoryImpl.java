package be.technocite.todo.repository.impl;

import be.technocite.todo.model.Todo;
import be.technocite.todo.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private List<Todo> todos = new ArrayList<>();

    @Override
    public Todo findById(long id) {
        return todos.stream()
                .filter(todo -> todo.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Todo save(Todo todo) {
        if(findById(todo.getId()) == null){
            todos.add(todo);
        }else{
            todos.remove(todo);
            todos.add(todo);
        }

        return findById(todo.getId());
    }
}
