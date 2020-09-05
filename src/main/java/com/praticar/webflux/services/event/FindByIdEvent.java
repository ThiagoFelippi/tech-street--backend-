package com.praticar.webflux.services.event;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindByIdEvent {

    private final EventRepository eventRepository;

    public Mono<Event> execute(int id) {
        return eventRepository.findById(id);
    }
}
