package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.CreateUserDto;
import net.javaguides.ems_backend.dto.UserDto;
import net.javaguides.ems_backend.entity.Role;
import net.javaguides.ems_backend.entity.User;
import net.javaguides.ems_backend.mapper.UserMapper;
import net.javaguides.ems_backend.model.AuthenticatedUser;
import net.javaguides.ems_backend.repository.UserRepository;
import net.javaguides.ems_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceimp implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDto register(CreateUserDto userDto){
        System.out.println("Request Body for User reg" + userDto);

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());

        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(Role.USER);
        User user = userRepository.save(newUser);

        return UserMapper.mapToUserDto(user);

    }


//    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
//        User user = userRepository.findByUsernameOrEmail(userNameOrEmail).orElseThrow(() ->
//                new UsernameNotFoundException(
//                        "User not found: " + userNameOrEmail
//                ));
//        return new AuthenticatedUser(user);
//    }
public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(userName).orElseThrow(() ->
            new UsernameNotFoundException(
                    "User not found: " + userName
            ));
    return new AuthenticatedUser(user);
}


//    public User login(CreateUserDto userDto){
//        System.out.println("Request Body for User reg" + userDto);
//
//        User newUser = new User();
//        newUser.setEmail(userDto.getEmail());
//
//        newUser.setUsername(userDto.getUsername());
//        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        newUser.setRole(Role.USER);
//        User user = userRepository.save(newUser);
//
//        return UserMapper.mapToUserDto(user);
//
//    }

}
