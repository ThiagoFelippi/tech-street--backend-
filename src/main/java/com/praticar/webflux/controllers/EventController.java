package com.praticar.webflux.controllers;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.entities.User;
import com.praticar.webflux.services.event.CreateEvent;
import com.praticar.webflux.services.event.FindAllEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final FindAllEvents findAllEvents;
    private final CreateEvent createEvent;


    @GetMapping()
    public Flux<Event> findAll(){
        return findAllEvents.execute();
    }

    @PostMapping()
    public Mono<Event> createEvent(@RequestBody Event event) throws Exception {
        return createEvent.execute(event);
    }
}
