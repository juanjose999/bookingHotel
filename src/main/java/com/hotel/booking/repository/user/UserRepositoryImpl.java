package com.hotel.booking.repository.user;

import com.hotel.booking.model.user.User;
import com.hotel.booking.repository.user.mongo.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final UserMongoRepository userMongoRepository;
    @Autowired
    public UserRepositoryImpl(UserMongoRepository userMongoRepository){
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> userFound = userMongoRepository.findByEmail(email);
        if (userFound.isPresent()){
            return userFound;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userMongoRepository.findAll();
    }

    @Override
    public User findUserById(String idUser) {
        return userMongoRepository.findById(idUser).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Boolean updateUser(String id, User user) {
        User foundUser = findUserById(id);
        if(foundUser != null){
            foundUser.setFirstName(user.getFirstName());
            foundUser.setLastName(user.getLastName());
            foundUser.setEmail(user.getEmail());
            foundUser.setPassword(user.getPassword());
            foundUser.setRegistrationDate(user.getRegistrationDate());

            userMongoRepository.save(foundUser);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(String id) {
        User foundUser = findUserById(id);
        if(foundUser != null){
            userMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
