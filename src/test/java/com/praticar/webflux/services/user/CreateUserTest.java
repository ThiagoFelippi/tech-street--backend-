package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
import com.praticar.webflux.services.user.utils.CreateUserUtil;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor
public class CreateUserTest {

    @InjectMocks
    private CreateUser createUser;

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private ValidateUser validateUser;

    private final User user = CreateUserUtil.createValidUser();

    @BeforeEach
    public void setUp() throws Exception {

        BDDMockito.when(validateUser.execute(user))
                .thenReturn(user);

        BDDMockito.when(userRepositoryMock.save(user))
                .thenReturn(Mono.just(user));

    }

    @Test
    void ShouldCreateUser_Valid() throws Exception {
        User user = User
                .builder()
                .username("thiago")
                .password("12345")
                .build();


        StepVerifier
                .create(createUser.execute(user))
                .expectSubscription()
                .expectNext(user)
                .verifyComplete();
    }

}
