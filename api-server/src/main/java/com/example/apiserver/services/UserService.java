package com.example.apiserver.services;

import com.example.apiserver.models.User;
import com.example.apiserver.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> getAll() {
        return this.repository.findAll();
    }

    public User getUserById(long id) {
        return this.repository.getUserById(id);
    }
}
