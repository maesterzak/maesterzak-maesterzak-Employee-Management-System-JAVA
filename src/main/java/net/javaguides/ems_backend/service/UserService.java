package net.javaguides.ems_backend.service;


import net.javaguides.ems_backend.dto.CreateUserDto;
import net.javaguides.ems_backend.dto.LoginRequestDto;
import net.javaguides.ems_backend.dto.UserDto;

public interface UserService {

    UserDto register(CreateUserDto userDto);

}
