package com.praticar.webflux.repositories;

import com.praticar.webflux.entities.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, Long> {

    Mono<Event> findById(long id);
    Flux<Event> findByTags(String tag);
    Mono<Event> findByName(String name);

}
