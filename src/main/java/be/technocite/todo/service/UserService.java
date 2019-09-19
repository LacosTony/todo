package be.technocite.todo.service;

import be.technocite.todo.api.dto.UserInfoDTO;
import be.technocite.todo.api.dto.UserRegistrationDto;
import be.technocite.todo.model.User;
import be.technocite.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserInfoDTO findByEmail(String email){
        return convertToInfoDTO(userRepository.findByEmail(email));
    }

    public UserInfoDTO findById(long id){
        return convertToInfoDTO(userRepository.findById(id));
    }


        public User save(UserRegistrationDto userDTO){
        User user = new User();
        //Todo Il faut passer un DTO en paramètre de cette méthode et passer les valeurs dans les setters de notre user
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         //Todo
        return null;
    }

    private UserInfoDTO convertToInfoDTO(User user){
        return new UserInfoDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

}
