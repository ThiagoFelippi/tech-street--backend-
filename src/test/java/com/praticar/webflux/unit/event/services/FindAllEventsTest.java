package com.praticar.webflux.unit.event.services;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.repositories.EventRepository;
import com.praticar.webflux.services.event.CreateEvent;
import com.praticar.webflux.services.event.FindAllEvents;
import com.praticar.webflux.services.event.ValidateEvent;
import com.praticar.webflux.unit.event.utils.CreateEventUtil;
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
public class FindAllEventsTest {
    @InjectMocks
    private FindAllEvents findAllEvents;

    @Mock
    private EventRepository eventRepository;

    private final Event event = CreateEventUtil.createValidEvent();

    @BeforeEach
    public void setUp() throws Exception {

        BDDMockito.when(eventRepository.findAll())
                .thenReturn(Flux.just(event));

    }

    @Test
    void ShouldCreateUser_Valid() throws Exception {

        StepVerifier
                .create(findAllEvents.execute())
                .expectSubscription()
                .expectNext(event)
                .verifyComplete();
    }
}
