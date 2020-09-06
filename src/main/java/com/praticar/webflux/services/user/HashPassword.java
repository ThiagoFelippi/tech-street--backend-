package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashPassword {

    public User execute(User user){
        String passwordHashed = new BCryptPasswordEncoder().encode(user.getPassword());
        return User
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(passwordHashed)
                .build();
    }
}
