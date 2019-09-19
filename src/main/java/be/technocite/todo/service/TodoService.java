package be.technocite.todo.service;

import be.technocite.todo.api.controller.UserController;
import be.technocite.todo.api.dto.TodoViewDTO;
import be.technocite.todo.model.Todo;
import be.technocite.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserController userController;

    public List<TodoViewDTO> findAll(){
        //todo faire la conversion
        //return todoRepository.findAll();

        return null;
    }

    public TodoViewDTO convertToViewDTO(Todo todo){
        return new TodoViewDTO(
                todo.getText(),
                userController.findById(todo.getId())
        );
    }


    public Todo save(TodoViewDTO todoDto) {
        //todo
        return null;
    }
}
