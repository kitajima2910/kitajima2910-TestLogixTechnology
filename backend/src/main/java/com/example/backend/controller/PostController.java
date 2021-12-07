package com.example.backend.controller;

import com.example.backend.dao.PostRepository;
import com.example.backend.entity.Post;
import com.example.backend.payload.response.PostResponse;
import com.example.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public ResponseEntity<?> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String createDate
    ) {

        Pageable pageable = PageRequest.of(page - 1, pageSize);

        Page<Post> posts = "".equals(createDate) ?
                postService.getAll(pageable) :
                postService.getAllCondition('%' + createDate + '%', pageable);

        int[][] counts = postService.getCount();
        List<PostResponse> postResponses = new ArrayList<>();
        List<Post> postsClone = posts.getContent();
        for(Post post : postsClone) {
            PostResponse postResponse = new PostResponse();
            postResponse.setId(post.getId())
                    .setTitle(post.getTitle())
                    .setConcept(post.getConcept())
                    .setCreateDate(post.getCreateDate());
            for(int i = 0; i < counts.length; i++) {
                if(post.getId().compareTo(BigInteger.valueOf(counts[i][0])) == 0) {
                    postResponse.setSumHeart(counts[i][1]);
                }
            }
            postResponse.setListHearts(postService.getHearts(post.getId()));
            postResponses.add(postResponse);
        }

        Page<PostResponse> postResponsePage = new PageImpl<>(postResponses, pageable, postResponses.size());

        return ResponseEntity.ok(postResponsePage);
    }



}
