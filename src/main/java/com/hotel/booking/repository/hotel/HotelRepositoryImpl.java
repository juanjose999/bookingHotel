package com.hotel.booking.repository.hotel;

import com.hotel.booking.model.Hotel;
import com.hotel.booking.repository.hotel.mongo.HotelMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HotelRepositoryImpl implements HotelRepository {
    @Autowired
    private HotelMongoRepository hotelMongoRepository;

    @Override
    public List<Hotel> getAllHotel() {
        return hotelMongoRepository.findAll();
    }

    @Override
    public Hotel findHotelById(String idHotel) {
        return hotelMongoRepository.findById(idHotel).get();
    }

    @Override
    public Hotel saveBooking(Hotel hotel) {
        return hotelMongoRepository.save(hotel);
    }

    @Override
    public Boolean updateHotel(String id, Hotel hotel) {
        Hotel foundHotel = findHotelById(id);
        if(foundHotel != null){
            foundHotel.setNameHotel(hotel.getNameHotel());
            hotelMongoRepository.save(foundHotel);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteHotel(String id) {
        Hotel foundHotel = findHotelById(id);
        if(foundHotel!= null){
            hotelMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
