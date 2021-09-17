package com.example.inflearn_springboot_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private LocalDateTime joinDate;

    public void updateUser(User updateUser){
        this.name = updateUser.getName();
    }
}
