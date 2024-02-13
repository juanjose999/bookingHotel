package com.hotel.booking.model.dto.user;

import com.hotel.booking.model.User;

public class UserMapper {

    public static UserResponseDto userToUserResponseDto(User user){
        return new UserResponseDto(
                user.getFirstName(),
                user.getLastName(),
                user.getStatusBooking()
        );
    }

    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getPhoneCel(),
                userDto.getIdCard(),
                userDto.getRegistrationDate(),
                userDto.getStatusBooking()
        );
    }
}
