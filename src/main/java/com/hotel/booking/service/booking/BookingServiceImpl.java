package com.hotel.booking.service.booking;

import com.hotel.booking.model.dto.booking.BookingDto;
import com.hotel.booking.model.dto.booking.BookingMapper;
import com.hotel.booking.model.dto.booking.BookingResponseDto;
import com.hotel.booking.repository.booking.BookingRepository;
import com.hotel.booking.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public List<BookingResponseDto> getAllBooking() {
        List<BookingResponseDto> bookingResponseDtos = new ArrayList<>();
        bookingRepository.getAllBooking().forEach(booking -> bookingResponseDtos.add(BookingMapper.booking_To_BookingResponseDto(booking)));
        return bookingResponseDtos;
    }

    @Override
    public BookingResponseDto findBookingById(String idBooking) {
        return BookingMapper.booking_To_BookingResponseDto(bookingRepository.findBookingById(idBooking));
    }

    @Override
    public BookingResponseDto saveBooking(BookingDto bookingDto) {
        return BookingMapper.booking_To_BookingResponseDto(bookingRepository.saveBooking(BookingMapper.bookingDto_To_Booking(bookingDto)));
    }

    @Override
    public Boolean updateBooking(String id, BookingDto bookingDto) {
        return bookingRepository.updateBooking(id, BookingMapper.bookingDto_To_Booking(bookingDto));
    }

    @Override
    public Boolean deleteBooking(String id) {
        return bookingRepository.deleteBooking(id);
    }
}
