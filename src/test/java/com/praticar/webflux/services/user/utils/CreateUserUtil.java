package com.praticar.webflux.services.user.utils;

import com.praticar.webflux.entities.User;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUtil {

    public static User createValidUser(){
        return User
                .builder()
                .username("thiago")
                .password("12345")
                .build();
    }

}
