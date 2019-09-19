package be.technocite.todo.service;

import be.technocite.todo.api.dto.UserRegistrationDTO;
import be.technocite.todo.model.User;
import be.technocite.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDTO userDTO){
        User user = new User();
        //Todo Il faut passer un DTO en paramètre de cette méthode et passer les valeurs dans les setters de notre user
        return userRepository.save(user);
    }
}
