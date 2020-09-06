package com.praticar.webflux.unit.user.services;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
import com.praticar.webflux.services.email.SendEmail;
import com.praticar.webflux.services.user.CreateUser;
import com.praticar.webflux.services.user.HashPassword;
import com.praticar.webflux.services.user.ValidateUser;
import com.praticar.webflux.unit.user.utils.CreateUserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class CreateUserTest {

    @InjectMocks
    private CreateUser createUser;

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private ValidateUser validateUser;

    @Mock
    private HashPassword hashPassword;

    @Mock
    private SendEmail sendEmail;

    private final User user = CreateUserUtil.createValidUser();

    @BeforeEach
    public void setUp() throws Exception {

        BDDMockito.when(hashPassword.execute(user))
                .thenReturn(user);

        BDDMockito.when(validateUser.execute(user))
                .thenReturn(user);

        BDDMockito.when(userRepositoryMock.save(user))
                .thenReturn(Mono.just(user));

    }

    @Test
    void ShouldCreateUser_Valid() throws Exception {

        StepVerifier
                .create(createUser.execute(user))
                .expectSubscription()
                .expectNext(user)
                .verifyComplete();
    }

}
