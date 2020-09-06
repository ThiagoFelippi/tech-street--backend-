package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
import com.praticar.webflux.services.email.MessagesEmail;
import com.praticar.webflux.services.email.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUser {
    private final UserRepository userRepository;
    private final ValidateUser validateUser;
    private final HashPassword hashPassword;
    private final SendEmail sendEmail;

    public Mono<User> execute(User user) throws Exception {
        User userValidated = validateUser.execute(user);

        User userWithPasswordHashed = hashPassword.execute(userValidated);

        sendEmail.sendSimpleMessage(
                user.getUsername()+"@gmail.com",
                "Seja bem vindo ao Street Tech "+ user.getUsername() +"!",
                MessagesEmail.welcomeMessage()
        );

        return userRepository.save(userWithPasswordHashed);
    }

}
