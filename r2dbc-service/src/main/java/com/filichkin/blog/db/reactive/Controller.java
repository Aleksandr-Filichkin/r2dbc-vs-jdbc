package com.filichkin.blog.db.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
@RequestMapping("/reactive")
public class Controller {

    private final R2DBCSubscriptionRepository userRepository;

    @Autowired
    public Controller(R2DBCSubscriptionRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("user/{id}")
    public Mono<User> get(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @PostMapping("user")
    public Mono<User> add(@RequestBody User user) {
        user.setCreated(Instant.now());
        return userRepository.save(user);
    }

    @GetMapping("users")
    public Flux<User> getWithLimit(@RequestParam int limit) {
        return userRepository.findWithLimit(limit);
    }

}
