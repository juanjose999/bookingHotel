package com.hotel.booking.service.user;

import com.hotel.booking.model.booking.Booking;
import com.hotel.booking.model.user.User;
import com.hotel.booking.dto.user.UserDto;
import com.hotel.booking.dto.user.UserMapper;
import com.hotel.booking.dto.user.UserResponseDto;
import com.hotel.booking.repository.booking.BookingRepository;
import com.hotel.booking.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User findByEmail(String email) {
        User userFound = userRepository.findByEmail(email).get();
        if (userFound != null){
            return userFound;
        }
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.getAllUsers().forEach(user -> userResponseDtos.add(UserMapper.userToUserResponseDto(user)));
        return userResponseDtos;
    }

    @Override
    public UserResponseDto findUserById(String id) {
        return UserMapper.userToUserResponseDto(userRepository.findUserById(id));
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);

        // Guardar User en su repositorio
        User savedUser = userRepository.saveUser(user);

        // Crear Booking asociada al User
        Booking newBooking = new Booking("agregado desde intelige", LocalDate.now(), LocalDate.now().plusDays(5), savedUser.getIdUser());
        newBooking.setUser(savedUser); // Establecer la relación bidireccional
        bookingRepository.saveBooking(newBooking);

        // Agregar la Booking al User y actualizar en su repositorio
        savedUser.getBookingsList().add(newBooking);
        userRepository.updateUser(savedUser.getIdUser(), savedUser);

        // Mapear el resultado a UserResponseDto y devolverlo
        return UserMapper.userToUserResponseDto(savedUser);
    }


    @Override
    public Boolean updateUser(String id, UserDto userDto) {
        return userRepository.updateUser(id, UserMapper.userDtoToUser(userDto));
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

}
