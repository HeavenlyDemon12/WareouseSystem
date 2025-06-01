package com.example.warehouse.dto.mapper;

import com.example.warehouse.dto.request.UserRegistrationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.entity.User;
import com.example.warehouse.enums.UserRole;
import org.springframework.stereotype.Controller;

import java.util.Locale;
@Controller
public class UserMapper{

    public User userToEntity(UserRegistrationRequest source, User target){
        target.setUsername(source.username());
        target.setEmail(source.email());
        target.setPassword(source.password());
        target.setUserRole(source.userRole());//problem
        return target;
    }

    public UserResponse userToResponse(User user){
        return new UserResponse(user.getUserId(),user.getUsername(),user.getEmail(),user.getUserRole().name(),user.getCreatedAt().toEpochMilli(),user.getLastModifiedAt().toEpochMilli());
    }

    public User requestToEntity(UserRequest request, User target){
        target.setUsername(request.username());
        target.setEmail(request.email());
        target.setPassword(request.password());
        return target;
    }

}
