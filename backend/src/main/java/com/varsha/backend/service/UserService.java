package com.varsha.backend.service;

import org.springframework.stereotype.Service;

import com.varsha.backend.model.User;
import com.varsha.backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection (no @Autowired needed)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
