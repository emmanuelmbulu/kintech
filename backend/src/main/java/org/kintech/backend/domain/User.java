package org.kintech.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String fullname;
    private String emailAddress;
    private String phoneNumber;
    private String physicalAddress;

    public User(String fullname, String emailAddress, String phoneNumber, String physicalAddress) {
        this(null, fullname, emailAddress, phoneNumber, physicalAddress);
    }
}
