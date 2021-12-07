package com.example.backend.dao;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    boolean existsByEmail(String email);

    Optional<User> findUserByEmailAndPassword(String email, String password);

}
