package com.example.inflearn_springboot_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private LocalDateTime joinDate;
}
