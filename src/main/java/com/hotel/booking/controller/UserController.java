package com.hotel.booking.controller;

import com.hotel.booking.model.dto.user.UserDto;
import com.hotel.booking.model.dto.user.UserResponseDto;
import com.hotel.booking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        try{
            List<UserResponseDto> users = userService.getAllUser();
            return ResponseEntity.ok(users);
        }catch (Exception e) {
            System.out.println("error in getAllUser controller: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable String userId){
        try{
            return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("The user " + userId + "does't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String userId, @RequestBody UserDto userDto){
        try{
            Boolean foundUserUpdate = userService.updateUser(userId,userDto);
            if(foundUserUpdate){
                return new ResponseEntity("the user update is ok." , HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + userId + " doesn't in the data base." , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }
}
