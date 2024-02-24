package com.springboot.bikroy.repository;

import com.springboot.bikroy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    //Boolean findFirstByEmail(String email);

    User findFirstByEmail(String username);

    Optional<User> findByEmail(String username);
}
