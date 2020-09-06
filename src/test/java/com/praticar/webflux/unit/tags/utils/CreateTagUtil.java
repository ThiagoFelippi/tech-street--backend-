package com.praticar.webflux.unit.tags.utils;

import com.praticar.webflux.entities.Tag;
import com.praticar.webflux.entities.User;
import org.springframework.stereotype.Service;

@Service
public class CreateTagUtil {

    public static Tag createValidTag(){
        return Tag
                .builder()
                .tagName("Javascript")
                .build();
    }

}
