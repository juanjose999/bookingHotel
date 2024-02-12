package com.hotel.booking.service.user;

import com.hotel.booking.model.User;
import com.hotel.booking.model.dto.user.UserDto;
import com.hotel.booking.model.dto.user.UserMapper;
import com.hotel.booking.model.dto.user.UserResponseDto;
import com.hotel.booking.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUser() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.getAllUser().forEach(user -> userResponseDtos.add(UserMapper.user_To_UserResponseDto(user)));
        return userResponseDtos;
    }

    @Override
    public UserResponseDto findUserById(String id) {
        return UserMapper.user_To_UserResponseDto(userRepository.findUserById(id));
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        return UserMapper.user_To_UserResponseDto(userRepository.saveUser(UserMapper.userDto_To_User(userDto)));
    }


    @Override
    public Boolean updateUser(String id, UserDto userDto) {
        return userRepository.updateUser(id, UserMapper.userDto_To_User(userDto));
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

}
