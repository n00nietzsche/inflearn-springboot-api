package com.example.inflearn_springboot_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // /hello-world (end point)
    // @RequestMapping(method=RequestMethod.GET, path="/hello-world") -> Legacy 방법.
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello world";
    }
}
