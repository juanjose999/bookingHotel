package com.hotel.booking.service.user;

import com.hotel.booking.model.User;
import com.hotel.booking.model.dto.user.UserDto;
import com.hotel.booking.model.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(String idUser);
    UserResponseDto saveUser(UserDto userDto);
    Boolean updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
}
