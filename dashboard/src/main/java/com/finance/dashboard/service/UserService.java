package com.finance.dashboard.service;

import org.springframework.stereotype.Service;

import com.finance.dashboard.dto.LoginRequest;
import com.finance.dashboard.dto.RegisterRequest;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository repo;

    
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // REGISTER
    public User register(RegisterRequest req) {

        if (repo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());

        return repo.save(user);
    }

    // LOGIN
    public String login(LoginRequest req) {

        User user = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login successful";
    }
}