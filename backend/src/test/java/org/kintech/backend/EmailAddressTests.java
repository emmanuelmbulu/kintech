package org.kintech.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kintech.backend.domain.User;
import org.kintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class EmailAddressTests {

    @Autowired
    private UserService userService;

    @Test
    void validEmailAddressProvided() {
        String emailAddress = "hello@project.us.org";
        User anUser = new User(null, emailAddress, null, null);

        Assertions.assertTrue(userService.userHasValidEmail(anUser));
    }
    @Test
    void invalidEmailAddressProvided() {
        String emailAddress = "hello@project";
        User anUser = new User(null, emailAddress, null, null);

        Assertions.assertFalse(userService.userHasValidEmail(anUser));
    }

    @Test
    void emptyEmailProvided() {
    }
}
