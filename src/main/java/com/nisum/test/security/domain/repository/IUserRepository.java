package com.nisum.test.security.domain.repository;

import com.nisum.test.security.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

}
