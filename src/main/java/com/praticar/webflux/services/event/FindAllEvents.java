package com.praticar.webflux.services.event;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllEvents {
    private final EventRepository eventRepository;

    public Flux<Event> execute() {
        return eventRepository.findAll();
    }
}
