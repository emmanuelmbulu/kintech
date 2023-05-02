package org.kintech.backend.service;

import org.kintech.backend.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean userHasValidEmail(User user);
}
