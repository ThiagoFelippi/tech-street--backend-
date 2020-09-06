package com.praticar.webflux.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String username;

    public UserDTO(Mono<User> user){
        this.username = user.block().getUsername();
    }
}
