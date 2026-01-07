package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService service;
    @GetMapping("/")
    public String home() {
        return "redirect:/login.html";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User u) {
        service.register(u);
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User u) {

        boolean valid = service.login(u.getUsername(), u.getPassword());

        if (valid) {
            return ResponseEntity.ok("Login success");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
