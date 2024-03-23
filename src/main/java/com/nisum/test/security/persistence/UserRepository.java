package com.nisum.test.security.persistence;

import com.nisum.test.security.domain.entities.User;
import com.nisum.test.security.domain.repository.IUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepository implements IUserRepository {

}
