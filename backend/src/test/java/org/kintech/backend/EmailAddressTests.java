package org.kintech.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kintech.backend.domain.User;
import org.kintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailAddressTests {

    @Autowired
    private UserService userService;

    @Test
    void validEmailAddressProvided() {
        String emailAddress = "hello@project.us.org";
        User anUser = new User(null, emailAddress, null, null);

        Assertions.assertTrue(userService.userHasValidEmailAddress(anUser));
    }
    @Test
    void invalidEmailAddressProvided() {
        String emailAddress = "hello@project";
        User anUser = new User(null, emailAddress, null, null);

        Assertions.assertFalse(userService.userHasValidEmailAddress(anUser));
    }

    @Test
    void emptyEmailProvided() {
        String emailAddress = "";
        User anUser = new User(null, emailAddress, null, null);

        Assertions.assertFalse(userService.userHasValidEmailAddress(anUser));
    }

    @Test
    void noEmailProvided() {
        String emailAddress = null;
        User anUser = new User(null, emailAddress, null, null);

        Assertions.assertFalse(userService.userHasValidEmailAddress(anUser));
    }

    @Test
    void existedEmailProvided() {

    }
}
