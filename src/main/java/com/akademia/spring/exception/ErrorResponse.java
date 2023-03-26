package com.akademia.spring.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @JsonFormat(pattern = "yyyy-mm-dd HH-mm-ss")
    private LocalDateTime time;
    private int statusCode;
    private String path;
    private String message;

}
