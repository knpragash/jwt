package com.jwt.jwt.controllers;

import com.jwt.jwt.config.UserAuthenticationProvider;
import com.jwt.jwt.dto.LoginDto;
import com.jwt.jwt.dto.RegisterDto;
import com.jwt.jwt.dto.UserDto;
import com.jwt.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3200")
public class MessagesController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages() {
        return ResponseEntity.ok(Arrays.asList("first", "3rd"));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto) {

        System.out.println("Register: " + registerDto.toString());
        UserDto userDto = userService.register(registerDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));

        return ResponseEntity.ok()
                .header("HedDet", "haha head detail")
                .header("2nd Head", "well done")
                .body(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto, @RequestHeader (name="Authorization") String token) {
        System.out.println("Login: " + token + " , " + loginDto.toString());
        UserDto userDto = new UserDto(1L, "Pragash", "Karuppiah", "raavana", null);
        userDto.setToken(token);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDto);
    }
}
