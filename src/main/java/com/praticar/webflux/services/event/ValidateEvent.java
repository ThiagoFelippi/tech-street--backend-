package com.praticar.webflux.services.event;

import com.praticar.webflux.entities.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidateEvent {

    // Test validate
    public List<String> validateTags(Event event) throws Exception {

        // change to real tags
        List<String> validTags = new ArrayList<>();
        validTags.add("javascript");
        validTags.add("typescript");

        List<String> tags = event.getTags()
                .stream()
                .filter(tag -> validTags.contains(tag))
                .collect(Collectors.toList());

        if(tags == null){
            throw new Exception("Tags not valid");
        }

        return tags;
    }

    public Event execute(Event event) throws Exception {
        validateTags(event);
        return event;
    }
}
