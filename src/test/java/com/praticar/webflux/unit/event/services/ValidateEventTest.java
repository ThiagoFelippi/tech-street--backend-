package com.praticar.webflux.unit.event.services;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.unit.event.utils.CreateEventUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class ValidateEventTest {

    private final Event event = CreateEventUtil.createValidEvent();

    @Test
    void ShouldValidateEventInfos_Valid(){
        Assertions.assertEquals(event, event);
    }
}

