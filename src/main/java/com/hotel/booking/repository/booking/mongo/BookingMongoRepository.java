package com.hotel.booking.repository.booking.mongo;

import com.hotel.booking.model.booking.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingMongoRepository extends MongoRepository<Booking, String> {


}
