package com.praticar.webflux.repositories;

import com.praticar.webflux.entities.Tag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends ReactiveCrudRepository<Tag, Integer> {
}
