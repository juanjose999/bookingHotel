package com.hotel.booking.model.dto.user;

import com.hotel.booking.model.User;

public class UserMapper {

    public static UserResponseDto user_To_UserResponseDto(User user){
        return new UserResponseDto(
                user.getFirstName(),
                user.getLastName(),
                user.getStatusBooking()
        );
    }

    public static User userDto_To_User(UserDto userDto){
        return new User(
                userDto.getIdUser(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getPhoneCel(),
                userDto.getIdCard(),
                userDto.getRegistrationDate(),
                userDto.getStatusBooking()
        );
    }
}
