package net.javaguides.ems_backend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.CreateUserDto;
import net.javaguides.ems_backend.dto.LoginRequestDto;
import net.javaguides.ems_backend.dto.UserDto;
import net.javaguides.ems_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> loginUser(@RequestBody LoginRequestDto userDto) {
        //String savedUser = securityContext.;
        return null;//new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
}
