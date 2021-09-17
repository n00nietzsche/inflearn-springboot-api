package com.example.inflearn_springboot_api.service;

import com.example.inflearn_springboot_api.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoServiceTest {
    @Autowired private UserDaoService userDaoService;

    @Test
    public void deleteTest() {
        List<User> users = userDaoService.findAll();

        for (User user : users) {
            System.out.println("user = " + user);
        }

        User deleteById = userDaoService.deleteById(3);
        System.out.println("deleteById = " + deleteById);

        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}