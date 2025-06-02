package com.example.warehouse.service.impl;

import com.example.warehouse.dto.mapper.UserMapper;
import com.example.warehouse.dto.request.UserRegistrationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.entity.Admin;
import com.example.warehouse.entity.Staff;
import com.example.warehouse.entity.User;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.exceptions.UserNotFoundByEmail;
import com.example.warehouse.exceptions.UserNotFoundByIdException;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.warehouse.security.AuthUtils.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse addUser(UserRegistrationRequest urr) {

            UserRole role = urr.userRole();
            User user;
            if (role == UserRole.STAFF) {
                user = userMapper.userToEntity(urr, new Staff());
            } else if (role == UserRole.ADMIN) {
                user = userMapper.userToEntity(urr, new Admin());
            } else {
                throw new IllegalArgumentException("Unsupported role: " + role);
            }

            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            userRepository.save(user);
            return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest request) {

        User exUser = getCurrentUserName().map(username -> userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundByEmail("User not found by id") ) )
                .orElseThrow(() -> new UserNotFoundByEmail("User is not Authorized"));

        User user = userMapper.requestToEntity(request,exUser);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
       userRepository.save(user);
       return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse findUserById(String userId) {
        return userRepository.findById(userId).map(userMapper::userToResponse).orElseThrow(()->new UserNotFoundByIdException("User Not Found Based On Id!!"));
    }

    @Override
    public UserResponse deleteUserById(String userId) {
       User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundByIdException("UserId Not Found!!"));
        userRepository.delete(user);
        return userMapper.userToResponse(user);
    }
}
