package com.jwt.jwt.service.user;

import com.jwt.jwt.dto.RegisterDto;
import com.jwt.jwt.dto.UserDto;
import com.jwt.jwt.entity.User;
import com.jwt.jwt.exceptions.EmailExistsException;
import com.jwt.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IService{

    @Autowired
    private UserRepository userRepository;

    public UserDto register(RegisterDto registerDto) {
        User user = new User();
        User newUser = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        try {
            newUser = userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new EmailExistsException("Email already exists");
        }

        UserDto userDto = new UserDto(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), null);
        return userDto;
    }
}
