package com.hotel.booking.service.user;

import com.hotel.booking.dto.user.UserDto;
import com.hotel.booking.dto.user.UserResponseDto;
import com.hotel.booking.model.user.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(String idUser);
    UserResponseDto saveUser(UserDto userDto);
    Boolean updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
}
