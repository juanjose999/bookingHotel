package com.hotel.booking.service.hotel;

import com.hotel.booking.model.dto.hotel.HotelDto;
import com.hotel.booking.model.dto.hotel.HotelMapper;
import com.hotel.booking.model.dto.hotel.HotelResponseDto;
import com.hotel.booking.repository.hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public List<HotelResponseDto> getAllHotel() {
        List<HotelResponseDto> hotelResponseDtos = new ArrayList<>();
        hotelRepository.getAllHotel().forEach(hotel -> hotelResponseDtos.add(HotelMapper.hotel_To_HotelResponseDto(hotel)));
        return hotelResponseDtos;
    }

    @Override
    public HotelResponseDto findHotelById(String idHotel) {
        return HotelMapper.hotel_To_HotelResponseDto(hotelRepository.findHotelById(idHotel));
    }

    @Override
    public HotelResponseDto saveBooking(HotelDto hotelDto) {
        return HotelMapper.hotel_To_HotelResponseDto(hotelRepository.saveBooking(HotelMapper.hotelDto_To_Hotel(hotelDto)));
    }

    @Override
    public Boolean updateHotel(String id, HotelDto hotelDto) {
        return hotelRepository.updateHotel(id, HotelMapper.hotelDto_To_Hotel(hotelDto));
    }

    @Override
    public Boolean deleteHotel(String id) {
        return hotelRepository.deleteHotel(id);
    }
}
