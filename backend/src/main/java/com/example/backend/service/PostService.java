package com.example.backend.service;

import com.example.backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface PostService {

    Page<Post> getAllCondition(String createDate, Pageable pageable);

    Page<Post> getAll(Pageable pageable);

    int[][] getCount();

    int[] getHearts(BigInteger postId);

}
