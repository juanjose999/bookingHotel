package com.hotel.booking.repository.user;

import com.hotel.booking.model.Hotel;
import com.hotel.booking.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUser();
    User findUserById(String idUser);
    User saveUser(User user);
    Boolean updateUser(String id, User user);
    Boolean deleteUser(String id);
}
