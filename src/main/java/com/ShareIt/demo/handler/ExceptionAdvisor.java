package com.ShareIt.demo.handler;

import com.ShareIt.demo.api.dto.ResponseDto;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseDto(e.getMessage());
    }
}
