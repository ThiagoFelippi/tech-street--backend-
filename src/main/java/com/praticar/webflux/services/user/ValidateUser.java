package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import org.springframework.stereotype.Service;

@Service
public class ValidateUser {

    public User execute(User user) throws Exception {
        return user;
    }
}
