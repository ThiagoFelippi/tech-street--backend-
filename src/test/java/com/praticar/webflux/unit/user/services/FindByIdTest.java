package com.praticar.webflux.unit.user.services;


import com.praticar.webflux.entities.User;
import com.praticar.webflux.repositories.UserRepository;
import com.praticar.webflux.services.user.FindByIdUser;
import com.praticar.webflux.unit.user.utils.CreateUserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class FindByIdTest {


    @InjectMocks
    private FindByIdUser findByIdUser;

    @Mock
    private UserRepository userRepositoryMock;

    private final User user = CreateUserUtil.createValidUser();

    @BeforeEach
    public void setUp() {

        BDDMockito.when(userRepositoryMock.findById((long) user.getId()))
                .thenReturn(Mono.just(user));
    }

    @Test
    void ShouldFindById_Valid(){

        StepVerifier
                .create(findByIdUser.execute(user.getId()))
                .expectSubscription()
                .expectNext(user)
                .verifyComplete();
    }
}
