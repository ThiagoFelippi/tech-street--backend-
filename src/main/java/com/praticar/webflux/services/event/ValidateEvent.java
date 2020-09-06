package com.praticar.webflux.services.event;

import com.praticar.webflux.entities.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidateEvent {

    public Event execute(Event event) throws Exception {
        return event;
    }
}
