package com.hotel.booking.repository.user.mongo;

import com.hotel.booking.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {
}
