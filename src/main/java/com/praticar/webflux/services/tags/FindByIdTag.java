package com.praticar.webflux.services.tags;

import com.praticar.webflux.entities.Tag;
import com.praticar.webflux.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindByIdTag {
    private final TagRepository tagRepository;

    public Mono<Tag> execute(int id){
        return tagRepository.findById(id);
    }
}
