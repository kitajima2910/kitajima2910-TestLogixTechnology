package com.example.backend.dao;

import com.example.backend.entity.Heart;
import com.example.backend.entity.HeartKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public interface HeartRepository extends JpaRepository<Heart, BigInteger> {

    boolean existsByPostIdAndUserId(BigInteger postId, BigInteger userId);

    Heart findHeartByPostIdAndUserId(BigInteger postId, BigInteger userId);

}
