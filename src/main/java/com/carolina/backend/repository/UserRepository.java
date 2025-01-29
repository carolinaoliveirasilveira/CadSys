package com.carolina.backend.repository;

import com.carolina.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNomeOrEmail(String name, String email);
}
