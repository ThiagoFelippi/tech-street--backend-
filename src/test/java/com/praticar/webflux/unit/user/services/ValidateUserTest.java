package com.praticar.webflux.unit.user.services;

import com.praticar.webflux.entities.User;
import com.praticar.webflux.services.user.ValidateUser;
import com.praticar.webflux.unit.user.utils.CreateUserUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@Slf4j
@SpringBootTest(classes = {ValidateUser.class})
public class ValidateUserTest {

    @Autowired
    private ValidateUser validateUser;

    private final User user = CreateUserUtil.createValidUser();

    @Test
    void ShouldValidateUserInfos_Valid() throws Exception {
        User userValidated = validateUser.execute(user);

        //        Assertions.assertEquals(user, userValidated);
    }

}
