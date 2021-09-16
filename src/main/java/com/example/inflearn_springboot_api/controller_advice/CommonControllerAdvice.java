package com.example.inflearn_springboot_api.controller_advice;

import com.example.inflearn_springboot_api.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse allExceptionsHandler(Exception e, HttpServletRequest request) {
        log.error("[Exception] :", e);
        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                messageSource.getMessage("error.server", null, null),
                request.getRequestURI()
        );
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ExceptionResponse notFoundExceptionHandler(UserNotFoundException e, HttpServletRequest request) {
        log.error("[Not Found Exception] :", e);
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                messageSource.getMessage("error.user_not_found", new Object[]{e.getUserId()}, null),
                request.getRequestURI()
        );
    }
}
