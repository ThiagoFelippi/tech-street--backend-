package com.praticar.webflux.services.event;

import com.praticar.webflux.entities.Event;
import org.springframework.stereotype.Service;

@Service
public class ValidateEvent {

    public Event execute(Event event) throws Exception {
        return event;
    }
}
