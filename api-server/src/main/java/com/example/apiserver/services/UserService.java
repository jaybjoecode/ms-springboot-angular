package com.example.apiserver.services;

import com.example.apiserver.models.User;
import com.example.apiserver.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getall() {
        return this.userRepository.findAll();
    }

    public User getUserById(long id) {
        return this.userRepository.getUserById(id);
    }
}
