package com.example.warehouse.dto.request;

public record UserRequest(
        String username,
        String email,
        String password
) {
}
