package com.hotel.booking.service.booking;

import com.hotel.booking.dto.booking.BookingDto;
import com.hotel.booking.dto.booking.BookingMapper;
import com.hotel.booking.dto.booking.BookingResponseDto;
import com.hotel.booking.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    @Autowired
    public  BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }
    @Override
    public List<BookingResponseDto> getAllBookings() {
        List<BookingResponseDto> bookingResponseDtos = new ArrayList<>();
        bookingRepository.getAllBookings().forEach(booking -> bookingResponseDtos.add(BookingMapper.bookingToBookingResponseDto(booking)));
        return bookingResponseDtos;
    }

    @Override
    public BookingResponseDto findBookingById(String idBooking) {
        return BookingMapper.bookingToBookingResponseDto(bookingRepository.findBookingById(idBooking));
    }

    @Override
    public BookingResponseDto saveBooking(BookingDto bookingDto) {
        return BookingMapper.bookingToBookingResponseDto(bookingRepository.saveBooking(BookingMapper.bookingDtoToBooking(bookingDto)));
    }

    @Override
    public Boolean updateBooking(String idBooking, BookingDto bookingDto) {
        return bookingRepository.updateBooking(idBooking, BookingMapper.bookingDtoToBooking(bookingDto));
    }

    @Override
    public Boolean deleteBooking(String id) {
        return bookingRepository.deleteBooking(id);
    }
}
