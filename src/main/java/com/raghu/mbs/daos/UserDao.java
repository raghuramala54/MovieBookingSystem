package com.raghu.mbs.daos;

import com.raghu.mbs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}