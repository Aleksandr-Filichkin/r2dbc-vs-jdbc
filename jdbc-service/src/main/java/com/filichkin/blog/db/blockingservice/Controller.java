package com.filichkin.blog.db.blockingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/blocking")
public class Controller {

    private final UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("user/{id}")
    public User get(@PathVariable long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("user")
    public User add(@RequestBody User user) {
        user.setCreated(Instant.now());
        return userRepository.save(user);
    }

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("users")
    public List<User> getAll(@RequestParam int limit) {
        return userRepository.findWithLimit(limit);
    }

}
