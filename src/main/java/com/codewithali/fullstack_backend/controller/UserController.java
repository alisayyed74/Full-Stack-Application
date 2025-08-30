package com.codewithali.fullstack_backend.controller;

import com.codewithali.fullstack_backend.exception.UserNotFoundException;
import com.codewithali.fullstack_backend.model.User;
import com.codewithali.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/User")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);

    }

    @GetMapping("/Users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/User/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/User/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/User/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with ID " + id + " has been deleted successfully.";
    }
}

