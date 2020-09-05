package com.praticar.webflux.unit.event.utils;

import com.praticar.webflux.entities.Event;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CreateEventUtil {

    public static Event createValidEvent(){
        return Event
                .builder()
                .name("thiagothiagothiagothiagothiago")
                .description("12345thiagothiagothiago")
                .capacity(100)
                .tags(Collections.singletonList("javascript"))
                .type("Tecnologia")
                .build();
    }

}
