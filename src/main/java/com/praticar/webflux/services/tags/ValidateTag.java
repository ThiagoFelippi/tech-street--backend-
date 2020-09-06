package com.praticar.webflux.services.tags;

import com.praticar.webflux.entities.Tag;
import org.springframework.stereotype.Service;

@Service
public class ValidateTag {

    public Tag validateLength(Tag tag) throws Exception {
        if(tag.getTagName().length() > 12){
            throw new Exception("TagName cannot have more than 12 characters");
        }

        return tag;
    }

    public Tag execute(Tag tag) throws Exception {
        validateLength(tag);
        return tag;
    }
}
