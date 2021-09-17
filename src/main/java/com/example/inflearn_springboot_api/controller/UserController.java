package com.example.inflearn_springboot_api.controller;

import com.example.inflearn_springboot_api.domain.User;
import com.example.inflearn_springboot_api.service.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/exception")
    public void exception(){
        throw new RuntimeException();
    }

    @PostMapping("")
    // @RequestBody: HTTP 요청 Body 영역에 User 객체가 올 것이다.
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody(required = true) User user, @PathVariable int id) {
        service.updateById(id, user);

        return ResponseEntity.noContent().build();
    }
}
