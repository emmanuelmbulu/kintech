package org.kintech.backend.service.implementation;

import org.kintech.backend.domain.User;
import org.kintech.backend.repository.UserRepository;
import org.kintech.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImplementation implements UserService {
    final private UserRepository repository;

    public UserServiceImplementation(@Autowired UserRepository userRepository) {
        repository = userRepository;
    }

    @Override
    public boolean userHasValidEmailAddress(User user) {
        if(user == null || user.getEmailAddress() == null) return false;

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[A-Z0-9-]+\\.)+[A-Z]{2,6}$";

        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(user.getEmailAddress());
        return matcher.find();
    }

    @Override public boolean userProvidedUsedEmailAddress(User user) {
        return repository.findOneByEmailAddress(user.getEmailAddress()) != null;
    }
}
