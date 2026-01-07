package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public void register(User user) {
        repo.save(user);
    }

    public boolean login(String username, String password) {
        User user = repo.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
