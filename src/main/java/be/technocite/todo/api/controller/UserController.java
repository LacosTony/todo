package be.technocite.todo.api.controller;

import be.technocite.todo.api.dto.UserInfoDTO;
import be.technocite.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public UserInfoDTO findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public UserInfoDTO findById(@PathVariable long id){
        return userService.findById(id);
    }

}
