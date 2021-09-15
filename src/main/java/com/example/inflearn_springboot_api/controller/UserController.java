package com.example.inflearn_springboot_api.controller;

import com.example.inflearn_springboot_api.domain.User;
import com.example.inflearn_springboot_api.service.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDaoService service;

    @GetMapping("")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // 사실 @PathVariable 은 문자로 들어오지만, int 형태로 컨버팅 되는 것임.
    // 이전에 들었던 MVC 2편 컨버터 강의 참고
    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("")
    // @RequestBody: HTTP 요청 Body 영역에 User 객체가 올 것이다.
    public User addUser(@RequestBody User user) {
        return service.save(user);
    }
}
