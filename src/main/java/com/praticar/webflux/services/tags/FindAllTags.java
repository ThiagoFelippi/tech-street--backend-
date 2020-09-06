package com.praticar.webflux.services.tags;

import com.praticar.webflux.entities.Tag;
import com.praticar.webflux.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllTags {
    private TagRepository tagRepository;

    public Flux<Tag> execute(){
        return tagRepository.findAll();
    }
}
