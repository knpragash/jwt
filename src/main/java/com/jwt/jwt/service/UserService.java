package com.jwt.jwt.service;

import com.jwt.jwt.dto.LoginDto;
import com.jwt.jwt.dto.RegisterDto;
import com.jwt.jwt.dto.UserDto;
import com.jwt.jwt.entity.User;
import com.jwt.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto register(RegisterDto registerDto) {
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        User newUser =  userRepository.save(user);

        UserDto userDto = new UserDto(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), null);
        return userDto;
    }
}
