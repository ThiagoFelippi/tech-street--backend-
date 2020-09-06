package com.praticar.webflux.unit.event.services;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.repositories.EventRepository;
import com.praticar.webflux.services.event.CreateEvent;
import com.praticar.webflux.services.event.ValidateEvent;
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
public class CreateEventTest {
    @InjectMocks
    private CreateEvent createEvent;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private ValidateEvent validateEvent;

    private final Event event = CreateEventUtil.createValidEvent();

    @BeforeEach
    public void setUp() throws Exception {

        BDDMockito.when(validateEvent.execute(event))
                .thenReturn(event);

        BDDMockito.when(eventRepository.save(event))
                .thenReturn(Mono.just(event));

    }

    @Test
    void ShouldCreateEvent_Valid() throws Exception {

        StepVerifier
                .create(createEvent.execute(event))
                .expectSubscription()
                .expectNext(event)
                .verifyComplete();
    }
}
