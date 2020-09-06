package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.entities.UserDTO;
import com.praticar.webflux.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUser {
    private final UserRepository userRepository;
    private final ValidateUser validateUser;
    private final HashPassword hashPassword;

    public Mono<User> execute(User user) throws Exception {
        User userValidated = validateUser.execute(user);

        User userWithPasswordHashed = hashPassword.execute(userValidated);

        return userRepository.save(userWithPasswordHashed);
    }

}
