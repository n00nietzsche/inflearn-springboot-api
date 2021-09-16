package com.example.inflearn_springboot_api.controller_advice;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timeStamp = LocalDateTime.now();
    private final int httpStatusCode;
    private final String message;
    private final String description;
}
