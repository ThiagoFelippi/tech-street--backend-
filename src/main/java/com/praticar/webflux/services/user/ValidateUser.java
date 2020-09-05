package com.praticar.webflux.services.user;

import com.praticar.webflux.entities.User;
import org.springframework.stereotype.Service;

@Service
public class ValidateUser {

    private String validatePassword(String password) throws Exception {
        if(password.length() < 5){
            throw new Exception("Password have less than 5 characters");
        }

        if(password.length() > 12){
            throw new Exception("Password have more than 12 characters");
        }

        return password;
    }

    private String validateUsername(String username) throws Exception {
        if(username.length() < 3){
            throw new Exception("Password have less than 3 characters");
        }

        if(username.length() > 15){
            throw new Exception("Password have more than 15 characters");
        }

        return username;
    }

    public User execute(User user) throws Exception {
        validateUsername(user.getUsername());
        validatePassword(user.getPassword());
        return user;
    }
}
