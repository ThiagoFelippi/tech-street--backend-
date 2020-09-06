package com.praticar.webflux.unit.tags.services;

import com.praticar.webflux.entities.Event;
import com.praticar.webflux.entities.Tag;
import com.praticar.webflux.repositories.EventRepository;
import com.praticar.webflux.repositories.TagRepository;
import com.praticar.webflux.services.event.CreateEvent;
import com.praticar.webflux.services.event.ValidateEvent;
import com.praticar.webflux.services.tags.CreateTag;
import com.praticar.webflux.services.tags.ValidateTag;
import com.praticar.webflux.unit.event.utils.CreateEventUtil;
import com.praticar.webflux.unit.tags.utils.CreateTagUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class CreateTagTest {
    @InjectMocks
    private CreateTag createTag;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private ValidateTag validateTag;

    private final Tag tag = CreateTagUtil.createValidTag();

    @BeforeEach
    public void setUp() throws Exception {

        BDDMockito.when(validateTag.execute(tag))
                .thenReturn(tag);

        BDDMockito.when(tagRepository.save(tag))
                .thenReturn(Mono.just(tag));

    }

    @Test
    void ShouldCreateTag_Valid() throws Exception {

        StepVerifier
                .create(createTag.execute(tag))
                .expectSubscription()
                .expectNext(tag)
                .verifyComplete();
    }
}
