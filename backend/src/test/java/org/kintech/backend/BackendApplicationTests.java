package org.kintech.backend;

import org.junit.jupiter.api.Test;
import org.kintech.backend.domain.User;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BackendApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    void userCreationTest() {
        //Given
        String fullname = "John Doe";
        String emailAddress = "john.doe@miu.edu";
        String phoneNumber = "1234567890";
        String physicalAddress = "1000N 4th Street, Fairfield, IA 52557";

        //When (Act)
        User anUser = new User(fullname, emailAddress, phoneNumber, physicalAddress);

        //Then (Assert)
        assertEquals(fullname, anUser.getFullname());
        assertEquals(emailAddress, anUser.getEmailAddress());
        assertEquals(phoneNumber, anUser.getPhoneNumber());
        assertEquals(physicalAddress, anUser.getPhysicalAddress());
    }
}
