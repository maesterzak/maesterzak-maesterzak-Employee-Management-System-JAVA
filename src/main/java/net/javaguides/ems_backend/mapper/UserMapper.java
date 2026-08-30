package net.javaguides.ems_backend.mapper;

import net.javaguides.ems_backend.dto.CreateUserDto;
import net.javaguides.ems_backend.dto.UserDto;
import net.javaguides.ems_backend.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()

        );
    }

    public static User mapToUser(CreateUserDto userDto){
        return new User(
                null,
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                null

        );
    }
}

