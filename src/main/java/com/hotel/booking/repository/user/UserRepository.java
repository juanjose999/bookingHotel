package com.hotel.booking.repository.user;

import com.hotel.booking.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    List<User> getAllUsers();
    User findUserById(String idUser);
    User saveUser(User user);
    Boolean updateUser(String id, User user);
    Boolean deleteUser(String id);
}
