package com.praticar.webflux.controllers;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.services.user.CreateUser;
import com.praticar.webflux.services.user.FindAllUsers;
import com.praticar.webflux.services.user.FindByIdUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final FindAllUsers findAllUsers;
    private final FindByIdUser findByIdUser;
    private final CreateUser createUser;

    @GetMapping()
    public Flux<User> findAll(){
        return findAllUsers.execute();
    }

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable long id){
        return findByIdUser.execute(id);
    }

    @PostMapping()
    public Mono<User> createUser(@RequestBody User user) throws Exception {
        return createUser.execute(user);
    }

}
