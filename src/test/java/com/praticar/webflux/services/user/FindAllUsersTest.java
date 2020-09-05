package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
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

    @BeforeEach
    public void setUp() {
        User user = User
                .builder()
                .username("thiago")
                .password("12345")
                .build();

        BDDMockito.when(userRepositoryMock.findAll())
                .thenReturn(Flux.just(user));
    }

    @Test
    void ShouldFindAllUsers_Valid(){
        User user = User
                .builder()
                .username("thiago")
                .password("12345")
                .build();


        StepVerifier
                .create(findAllUsers.execute())
                .expectSubscription()
                .expectNext(user)
                .verifyComplete();
    }
}
