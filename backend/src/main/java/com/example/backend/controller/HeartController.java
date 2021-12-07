package com.example.backend.controller;

import com.example.backend.entity.Heart;
import com.example.backend.entity.HeartKey;
import com.example.backend.payload.request.HeartRequest;
import com.example.backend.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/heart")
public class HeartController {

    @Autowired
    private HeartService heartService;

    @PostMapping("/process")
    public ResponseEntity<?> process(@RequestBody HeartRequest heartRequest) {
        Heart heart = new Heart();
        heart.setPostId(heartRequest.getPostId())
                .setUserId(heartRequest.getUserId());

        if(heartService.updateHeart(heart)) {
            return ResponseEntity.ok("Successfully");
        }
        return ResponseEntity.ok("Fail");
    }

}
