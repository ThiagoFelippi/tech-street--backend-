package com.praticar.webflux.unit.user.services;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
import com.praticar.webflux.services.user.FindAllUsers;
import com.praticar.webflux.unit.user.utils.CreateUserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class FindAllUsersTest {

    @InjectMocks
    private FindAllUsers findAllUsers;

    @Mock
    private UserRepository userRepositoryMock;

    private final User user = CreateUserUtil.createValidUser();

    @BeforeEach
    public void setUp() {

        BDDMockito.when(userRepositoryMock.findAll())
                .thenReturn(Flux.just(user));
    }

    @Test
    void ShouldFindAllUsers_Valid(){

        StepVerifier
                .create(findAllUsers.execute())
                .expectSubscription()
                .expectNext(user)
                .verifyComplete();
    }
}
