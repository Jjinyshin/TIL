package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
//    Optional<User> findByName(String name);

    boolean existsByName(String name);
}
