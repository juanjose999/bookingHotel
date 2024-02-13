package com.hotel.booking.repository.user;

import com.hotel.booking.model.User;
import com.hotel.booking.repository.user.mongo.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    private final UserMongoRepository userMongoRepository;
    @Autowired
    public UserRepositoryImpl(UserMongoRepository userMongoRepository){
        this.userMongoRepository = userMongoRepository;
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
            foundUser.setPhoneCel(user.getPhoneCel());
            foundUser.setIdCard(user.getIdCard());
            foundUser.setRegistrationDate(user.getRegistrationDate());
            foundUser.setStatusBooking(user.getStatusBooking());

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
