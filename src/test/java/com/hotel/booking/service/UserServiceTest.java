package com.hotel.booking.service;
import com.hotel.booking.model.user.User;
import com.hotel.booking.dto.user.UserDto;
import com.hotel.booking.dto.user.UserResponseDto;
import com.hotel.booking.repository.user.UserRepository;
import com.hotel.booking.service.user.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        // Simula la respuesta del repositorio
        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(new User(), new User()));

        // Llama al método del servicio
        List<UserResponseDto> result = userService.getAllUsers();

        // Verifica que la respuesta no sea nula y tenga la longitud esperada
        assertNotNull(result);
        assertEquals(2, result.size());

        // Verifica que el método del repositorio se haya llamado
        verify(userRepository, times(1)).getAllUsers();
    }

    @Test
    public void testFindUserById() {
        // Id de usuario simulado
        String userId = "123";

        // Simula la respuesta del repositorio
        when(userRepository.findUserById(userId)).thenReturn(new User());

        // Llama al método del servicio
        UserResponseDto result = userService.findUserById(userId);

        // Verifica que la respuesta no sea nula
        assertNotNull(result);

        // Verifica que el método del repositorio se haya llamado
        verify(userRepository, times(1)).findUserById(userId);
    }

    @Test
    public void testSaveUser() {
        // Crea un DTO simulado
        UserDto userDto = new UserDto();

        // Simula la respuesta del repositorio
        when(userRepository.saveUser(any(User.class))).thenReturn(new User());

        // Llama al método del servicio
        UserResponseDto result = userService.saveUser(userDto);

        // Verifica que la respuesta no sea nula
        assertNotNull(result);

        // Verifica que el método del repositorio se haya llamado con el argumento correcto
        verify(userRepository, times(1)).saveUser(any(User.class));
    }
}
