package com.praticar.webflux.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;
import java.io.Serializable;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String username;

    public UserDTO(Mono<User> user){
        this.username = user.block().getUsername();
    }

}
