package com.example.inflearn_springboot_api.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final int userId;

    public UserNotFoundException(int id) {
        this.userId = id;
    }
}
