package com.example.inflearn_springboot_api.controller_advice;

import com.example.inflearn_springboot_api.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {

    private final MessageSource messageSource;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ExceptionResponse notFoundExceptionHandler(UserNotFoundException e) {
        log.error("[Not Found Exception] :", e);
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                messageSource.getMessage("error.user_not_found", new Object[]{e.getUserId()}, null)
        );
    }
}
