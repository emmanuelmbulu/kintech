package org.kintech.backend.repository;

import org.kintech.backend.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public default User findOneByEmailAddress(String emailAddress) {
        return new User(null, emailAddress, null, null);
    }
}
