package com.praticar.webflux.services.tags;

import com.praticar.webflux.entities.Tag;
import org.springframework.stereotype.Service;

@Service
public class ValidateTag {

    public Tag execute(Tag tag) throws Exception {
        return tag;
    }
}
