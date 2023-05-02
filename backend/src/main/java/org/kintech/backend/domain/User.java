package org.kintech.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String fullname;
    private String emailAddress;
    private String phoneNumber;
    private String physicalAddress;


}
