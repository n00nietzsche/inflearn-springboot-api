package com.example.inflearn_springboot_api.bean;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HelloWorldBean {
    private final String message;
}
