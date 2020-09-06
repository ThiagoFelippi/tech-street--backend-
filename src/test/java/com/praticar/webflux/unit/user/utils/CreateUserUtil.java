package com.praticar.webflux.unit.user.utils;

import com.praticar.webflux.entities.User;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUtil {

    public static User createValidUser(){
        return User
                .builder()
                .id((long) 1)
                .username("thiago crespo")
                .password("123456")
                .build();
    }

}
