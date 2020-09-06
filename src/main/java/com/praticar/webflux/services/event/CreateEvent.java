package com.praticar.webflux.services.event;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateEvent {
    private final EventRepository eventRepository;
    private final ValidateEvent validateEvent;

    public Mono<Event> execute(Event event) throws Exception {
        validateEvent.execute(event);
        return eventRepository.save(event);
    }
}
