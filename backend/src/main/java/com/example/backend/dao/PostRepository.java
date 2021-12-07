package com.example.backend.dao;

import com.example.backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PostRepository extends JpaRepository<Post, BigInteger> {

    @Query(value="select * from post where create_date like ?1", nativeQuery = true)
    Page<Post> findPostsByCreateDate(String createDate, Pageable pageable);

    Page<Post> findAllByIdNotNull(Pageable pageable);

    @Query(value="select post_id, sum(heart) from heart group by post_id order by post_id asc", nativeQuery = true)
    int[][] findAllByCount();

    @Query(value = "select user_id from heart where post_id = ?1", nativeQuery = true)
    int[] findAllByHears(BigInteger postId);

}
