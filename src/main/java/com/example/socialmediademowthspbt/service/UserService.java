package com.example.socialmediademowthspbt.service;

import com.example.socialmediademowthspbt.model.*;
import com.example.socialmediademowthspbt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User login(String username) {
        return userRepo.findByUsername(username);
    }

    public void register(User user) {
        userRepo.save(user);
    }

    public User findById(int id) {
        return userRepo.findById((long) id).orElse(null) ;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public List<User> listUsers() {
        return userRepo.findAll();
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepo.findByUsername(username) != null;
    }

    public User getUserById(int id) {
        return userRepo.findById((long) id).orElse(null);
    }

    public List<User> getAllUsersExcept(int userId) {
        return userRepo.findAll()
                .stream()
                .filter(u -> u.getId() != userId)
                .collect(Collectors.toList());
    }

}
