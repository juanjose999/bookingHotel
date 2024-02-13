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

    private final HotelRepository hotelRepository;
    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }
    @Override
    public List<HotelResponseDto> getAllHotels() {
        List<HotelResponseDto> hotelResponseDtos = new ArrayList<>();
        hotelRepository.getAllHotels().forEach(hotel -> hotelResponseDtos.add(HotelMapper.hotelToHotelResponseDto(hotel)));
        return hotelResponseDtos;
    }

    @Override
    public HotelResponseDto findHotelById(String idHotel) {
        return HotelMapper.hotelToHotelResponseDto(hotelRepository.findHotelById(idHotel));
    }

    @Override
    public HotelResponseDto saveHotel(HotelDto hotelDto) {
        return HotelMapper.hotelToHotelResponseDto(hotelRepository.saveHotel(HotelMapper.hotelDtoToHotel(hotelDto)));
    }

    @Override
    public Boolean updateHotel(String id, HotelDto hotelDto) {
        return hotelRepository.updateHotel(id, HotelMapper.hotelDtoToHotel(hotelDto));
    }

    @Override
    public Boolean deleteHotel(String idHotel) {
        return hotelRepository.deleteHotel(idHotel);
    }
}
