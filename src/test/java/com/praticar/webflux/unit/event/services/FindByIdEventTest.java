package com.praticar.webflux.unit.event.services;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.repositories.EventRepository;
import com.praticar.webflux.services.event.FindAllEvents;
import com.praticar.webflux.services.event.FindByIdEvent;
import com.praticar.webflux.unit.event.utils.CreateEventUtil;
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
public class FindByIdEventTest {
    @InjectMocks
    private FindByIdEvent findByIdEvent;

    @Mock
    private EventRepository eventRepository;

    private final Event event = CreateEventUtil.createValidEvent();

    @BeforeEach
    public void setUp() throws Exception {

        BDDMockito.when(eventRepository.findById(10))
                .thenReturn(Mono.just(event));

    }

    @Test
    void ShouldFindEventById_Valid() throws Exception {

        StepVerifier
                .create(findByIdEvent.execute(10))
                .expectSubscription()
                .expectNext(event)
                .verifyComplete();
    }
}
