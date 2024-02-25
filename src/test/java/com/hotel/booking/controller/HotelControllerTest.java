package com.hotel.booking.controller;

import com.hotel.booking.dto.hotel.HotelDto;
import com.hotel.booking.dto.hotel.HotelResponseDto;
import com.hotel.booking.service.hotel.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    // Se llama antes de cada método de prueba para inicializar las anotaciones Mockito
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testGetAllHotels() {
        // Simula la respuesta del servicio
        when(hotelService.getAllHotels()).thenReturn(Arrays.asList(new HotelResponseDto(), new HotelResponseDto()));

        // Llama al método del controlador
        ResponseEntity<List<HotelResponseDto>> result = hotelController.getAllHotels();

        // Verifica que la respuesta no sea nula y tenga la longitud esperada
        assertNotNull(result);
        assertEquals(2, result.getBody().size());

        // Verifica que el método del servicio se haya llamado
        verify(hotelService, times(1)).getAllHotels();
    }

    @Test
    void testFindHotelById() {
        // Id de hotel simulado
        String hotelId = "123";

        // Simula la respuesta del servicio
        when(hotelService.findHotelById(hotelId)).thenReturn(new HotelResponseDto());

        // Llama al método del controlador
        ResponseEntity<HotelResponseDto> result = hotelController.findHotelById(hotelId);

        // Verifica que la respuesta no sea nula
        assertNotNull(result);

        // Verifica que el método del servicio se haya llamado
        verify(hotelService, times(1)).findHotelById(hotelId);
    }

    @Test
    void testSaveHotel() {
        // Crea un DTO simulado
        HotelDto hotelDto = new HotelDto();

        // Simula la respuesta del servicio
        when(hotelService.saveHotel(any(HotelDto.class))).thenReturn(new HotelResponseDto());

        // Llama al método del controlador
        ResponseEntity<HotelResponseDto> result = hotelController.saveHotel(hotelDto);

        // Verifica que la respuesta no sea nula
        assertNotNull(result);

        // Verifica que el método del servicio se haya llamado con el argumento correcto
        verify(hotelService, times(1)).saveHotel(any(HotelDto.class));
    }
}
