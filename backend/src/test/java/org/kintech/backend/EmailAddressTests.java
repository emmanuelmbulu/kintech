package org.kintech.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kintech.backend.domain.User;
import org.kintech.backend.repository.UserRepository;
import org.kintech.backend.service.UserService;
import org.kintech.backend.service.implementation.UserServiceImplementation;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmailAddressTests {

    @Mock
    private UserRepository repository;

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
        Assertions.assertNotNull(repository);

        String emailAddress = "xxy@xyz.com";
        User anUser = new User(null, emailAddress, null, null);

        Mockito.when(repository.findOneByEmailAddress(emailAddress)).thenReturn(new User(null, emailAddress, null, null));

        userService = new UserServiceImplementation(repository);
        Assertions.assertTrue(userService.userProvidedUsedEmailAddress(anUser));
    }
}
