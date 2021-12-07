package com.example.backend.serviceimpl;

import com.example.backend.dao.PostRepository;
import com.example.backend.entity.Post;
import com.example.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> getAllCondition(String createDate, Pageable pageable) {
        return postRepository.findPostsByCreateDate(createDate, pageable);
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAllByIdNotNull(pageable);
    }

    @Override
    public int[][] getCount() {
        return postRepository.findAllByCount();
    }

    @Override
    public int[] getHearts(BigInteger postId) {
        return postRepository.findAllByHears(postId);
    }

}
