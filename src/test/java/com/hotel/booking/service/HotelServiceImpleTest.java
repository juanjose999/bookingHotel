package com.hotel.booking.service;
import com.hotel.booking.model.hotel.Hotel;
import com.hotel.booking.dto.hotel.HotelDto;
import com.hotel.booking.dto.hotel.HotelResponseDto;
import com.hotel.booking.repository.hotel.HotelRepository;
import com.hotel.booking.service.hotel.HotelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class HotelServiceImpleTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllHotels() {
        // Simula la respuesta del repositorio
        when(hotelRepository.getAllHotels()).thenReturn(Arrays.asList(new Hotel(), new Hotel()));

        // Llama al método del servicio
        List<HotelResponseDto> result = hotelService.getAllHotels();

        // Verifica que la respuesta no sea nula y tenga la longitud esperada
        assertNotNull(result);
        assertEquals(2, result.size());

        // Verifica que el método del repositorio se haya llamado
        verify(hotelRepository, times(1)).getAllHotels();
    }

    @Test
    public void testFindHotelById() {
        // Id de hotel simulado
        String hotelId = "123";

        // Simula la respuesta del repositorio
        when(hotelRepository.findHotelById(hotelId)).thenReturn(new Hotel());

        // Llama al método del servicio
        HotelResponseDto result = hotelService.findHotelById(hotelId);

        // Verifica que la respuesta no sea nula
        assertNotNull(result);

        // Verifica que el método del repositorio se haya llamado
        verify(hotelRepository, times(1)).findHotelById(hotelId);
    }

    @Test
    public void testSaveHotel() {
        // Crea un DTO simulado
        HotelDto hotelDto = new HotelDto();

        // Simula la respuesta del repositorio
        when(hotelRepository.saveHotel(any(Hotel.class))).thenReturn(new Hotel());

        // Llama al método del servicio
        HotelResponseDto result = hotelService.saveHotel(hotelDto);

        // Verifica que la respuesta no sea nula
        assertNotNull(result);

        // Verifica que el método del repositorio se haya llamado con el argumento correcto
        verify(hotelRepository, times(1)).saveHotel(any(Hotel.class));
    }
}
