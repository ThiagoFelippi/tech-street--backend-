package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.entities.UserDTO;
import com.praticar.webflux.repositories.UserRepository;
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

    public UserDTO execute(User user) throws Exception {
        User userValidated = validateUser.execute(user);

        User userWithPasswordHashed = hashPassword.execute(userValidated);

        sendEmail.sendSimpleMessage(
                user.getUsername()+"@gmail.com",
                "Seja bem vindo " + user.getUsername(),
                "Parabéns, agora você faz parte do nosso banco de dados!"
        );

        Mono<User> userCreated = userRepository.save(userWithPasswordHashed);
        return new UserDTO(userCreated);
    }

}
