package com.example.backend.payload.response;

import com.example.backend.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse extends Post {

    private int sumHeart = 0;
    private int[] listHearts;

}
