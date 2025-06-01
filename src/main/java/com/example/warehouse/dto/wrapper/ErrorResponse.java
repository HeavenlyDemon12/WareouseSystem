package com.example.warehouse.dto.wrapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ErrorResponse {
    int status;
    String errorMessage;
}
