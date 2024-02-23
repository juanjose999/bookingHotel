package com.hotel.booking.repository.booking;

import com.hotel.booking.model.Booking;
import com.hotel.booking.repository.booking.mongo.BookingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BookingRepositoryImpl implements BookingRepository{
    @Autowired
    private BookingMongoRepository bookingMongoRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingMongoRepository.findAll();
    }

    @Override
    public Booking findBookingById(String idBooking) {
       Optional<Booking> optionalBooking = bookingMongoRepository.findById(idBooking);
       return optionalBooking.orElse(null);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingMongoRepository.save(booking);
    }

    @Override
    public Boolean updateBooking(String id, Booking booking) {
        Optional<Booking> optionalFoundBooking = bookingMongoRepository.findById(id);
        if (optionalFoundBooking.isPresent()) {
            Booking foundBooking = optionalFoundBooking.get();
            foundBooking.setNameHotel(booking.getNameHotel());
            foundBooking.setRegistrationStartDate(booking.getRegistrationStartDate());
            foundBooking.setRegistrationEndDate(booking.getRegistrationEndDate());
            bookingMongoRepository.save(foundBooking);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBooking(String id) {
        Optional<Booking> optionalBooking = bookingMongoRepository.findById(id);
        if(optionalBooking.isPresent()){
            bookingMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
