package com.jwt.jwt.service;

import com.jwt.jwt.dto.LoginDto;
import com.jwt.jwt.dto.RegisterDto;
import com.jwt.jwt.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto register(RegisterDto registerDto) {
        UserDto userDto = new UserDto(1L, "Pragash", "Karuppiah", registerDto.getUserName(), null);
        return userDto;
    }
}
