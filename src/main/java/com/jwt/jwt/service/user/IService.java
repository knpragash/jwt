package com.jwt.jwt.service.user;

import com.jwt.jwt.dto.RegisterDto;
import com.jwt.jwt.dto.UserDto;

public interface IService {
    public UserDto register(RegisterDto registerDto);
}
