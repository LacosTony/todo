package be.technocite.todo.api.controller;

import be.technocite.todo.api.dto.TodoViewDTO;
import be.technocite.todo.model.Todo;
import be.technocite.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    public List<TodoViewDTO> findAll(){
        return todoService.findAll();
    }

    @PostMapping
    public ResponseEntity<TodoViewDTO> save(TodoViewDTO todoDto){
        Todo todo = todoService.save(todoDto);
        if(todo != null){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
