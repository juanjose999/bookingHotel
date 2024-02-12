package com.hotel.booking.repository.user;

import com.hotel.booking.model.User;
import com.hotel.booking.repository.user.mongo.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public List<User> getAllUser() {
        return userMongoRepository.findAll();
    }

    @Override
    public User findUserById(String idUser) {
        return userMongoRepository.findById(idUser).get();
    }

    @Override
    public User saveBooking(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Boolean updateHotel(String id, User user) {
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
    public Boolean deleteHotel(String id) {
        User foundUser = findUserById(id);
        if(foundUser != null){
            userMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
