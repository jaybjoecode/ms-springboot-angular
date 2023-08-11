package com.example.apiserver.controllers;

import com.example.apiserver.models.User;
import com.example.apiserver.repositories.UserRepository;
import com.example.apiserver.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<User> get() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        User u = this.userService.getUserById(id);
        return u;
    }

    @PostMapping
    public String save(@RequestBody User user) {
        userRepository.save(user);
        return "saved";
    }

    @PutMapping("{id}")
    public String update(@RequestBody User user, @PathVariable String id) {
        User u = userRepository.findById(id).get();
        u.setAge(user.getAge());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setOccupation(user.getOccupation());
        userRepository.save(u);

        return "updated";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable String id) {
        User u = userRepository.getById(id);
        userRepository.delete(u);
        return "deleted";
    }

}
