package com.example.inflearn_springboot_api.service;

import com.example.inflearn_springboot_api.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "jake", LocalDateTime.now()));
        users.add(new User(2, "jack", LocalDateTime.now()));
        users.add(new User(3, "paul", LocalDateTime.now()));
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream()
                .filter((user) -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
