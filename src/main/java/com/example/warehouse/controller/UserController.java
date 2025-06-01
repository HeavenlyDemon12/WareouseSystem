package com.example.warehouse.controller;

import com.example.warehouse.dto.request.UserRegistrationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequest urr){
       UserResponse ur = userService.addUser(urr);
       ResponseStructure<UserResponse> responseStructure = new ResponseStructure(HttpStatus.CREATED.value(),"User Successfully Added Into the Database",ur);
       return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest request, @PathVariable String userId){
        UserResponse userResponse = userService.updateUser(request,userId);
        ResponseStructure<UserResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Update Details Update Successfully",userResponse);

        return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable String userId){
        UserResponse userResponse = userService.findUserById(userId);
        ResponseStructure<UserResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "User Find By Respected Id",userResponse);
        return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> deleteUserById(@PathVariable String userId){
        UserResponse userResponse = userService.deleteUserById(userId);
        ResponseStructure<UserResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "User Deleted!!",userResponse);
        return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);
    }
}
