package com.praticar.webflux.services.tags;

import com.praticar.webflux.entities.Tag;
import com.praticar.webflux.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateTag {
    private final TagRepository tagRepository;
    private final ValidateTag validateTag;

    public Mono<Tag> execute(Tag tag) throws Exception {
        validateTag.execute(tag);
        return tagRepository.save(tag);
    }

}
