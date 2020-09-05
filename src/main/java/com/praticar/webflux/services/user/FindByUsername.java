package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindByUsername {
    private final UserRepository userRepository;

    public Mono<User> execute(String username){
        return userRepository.findByUsername(username);
    }
}
