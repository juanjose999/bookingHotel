package com.hotel.booking.repository.hotel.mongo;

import com.hotel.booking.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelMongoRepository extends MongoRepository<Hotel, String> {
}
