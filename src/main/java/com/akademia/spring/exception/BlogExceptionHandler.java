package com.akademia.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class BlogExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notFoundHandler (NotFoundException exception, HttpServletRequest request){
        ErrorResponse errorResponse=new ErrorResponse(
        LocalDateTime.now(),
        HttpStatus.NOT_FOUND.value(),
        request.getRequestURL().toString(),
        exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
