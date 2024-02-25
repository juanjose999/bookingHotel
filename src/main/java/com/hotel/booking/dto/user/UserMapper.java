package com.hotel.booking.dto.user;

import com.hotel.booking.model.user.User;

public class UserMapper {

    public static UserResponseDto userToUserResponseDto(User user){
        return new UserResponseDto(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getBookingsList()
        );
    }

    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRegistrationDate(),
                userDto.getBookingsList()
        );
    }
}
