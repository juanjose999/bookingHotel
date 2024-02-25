package com.hotel.booking.controller;
import com.hotel.booking.controller.user.UserController;
import com.hotel.booking.dto.user.UserResponseDto;
import com.hotel.booking.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() {
        MockitoAnnotations.initMocks(this);

        when(userService.getAllUsers()).thenReturn(Arrays.asList(new UserResponseDto(), new UserResponseDto()));

        ResponseEntity<List<UserResponseDto>> responseEntity = userController.getAllUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void testFindUserById() {
        MockitoAnnotations.initMocks(this);

        when(userService.findUserById("123")).thenReturn(new UserResponseDto());
        ResponseEntity<UserResponseDto> responseEntity = userController.findUserById("123");


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(UserResponseDto.class, responseEntity.getBody().getClass());
    }

    @Test
    public void testFindUserByIdNotFound() {
        MockitoAnnotations.initMocks(this);

        when(userService.findUserById("456")).thenThrow(new NoSuchElementException());

        ResponseEntity<UserResponseDto> responseEntity = userController.findUserById("456");

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
