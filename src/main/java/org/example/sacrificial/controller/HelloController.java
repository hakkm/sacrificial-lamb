package org.example.sacrificial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }


    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return "Echo: " + message;
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam("input") String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
