package be.technocite.todo.service;

import be.technocite.todo.api.dto.UserInfoDTO;
import be.technocite.todo.api.dto.UserRegistrationDto;
import be.technocite.todo.model.User;
import be.technocite.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findById(long id){
        return userRepository.findById(id);
    }


    public User save(UserRegistrationDto userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        //Todo Il faut passer un DTO en paramètre de cette méthode et passer les valeurs dans les setters de notre user

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                //todo a Collection<? extends GrantedAuthorities>
                null
        );
         //Todo
    }

    private UserInfoDTO convertToInfoDTO(User user){
        return new UserInfoDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

}
