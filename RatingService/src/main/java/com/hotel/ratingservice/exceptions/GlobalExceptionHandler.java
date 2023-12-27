package com.hotel.ratingservice.exceptions;

import com.hotel.ratingservice.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFoundException ex)
    {
        ApiResponse response = ApiResponse.builder().message(ex.getMessage()).success(false).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
