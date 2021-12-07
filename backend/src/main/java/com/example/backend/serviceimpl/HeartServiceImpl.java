package com.example.backend.serviceimpl;

import com.example.backend.dao.HeartRepository;
import com.example.backend.entity.Heart;
import com.example.backend.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class HeartServiceImpl implements HeartService {

    @Autowired
    private HeartRepository heartRepository;

    @Override
    public boolean updateHeart(Heart heart) {
        if(!heartRepository.existsByPostIdAndUserId(heart.getPostId(), heart.getUserId())) {
            Heart newHeart = new Heart();
            newHeart.setPostId(heart.getPostId())
                    .setUserId(heart.getUserId())
                    .setHeart(1);
            heartRepository.save(newHeart);
            return true;
        } else {
            Heart newHeart = heartRepository.findHeartByPostIdAndUserId(heart.getPostId(), heart.getUserId());
            if(newHeart.getHeart() != 3) {
                newHeart.setHeart(newHeart.getHeart() + 1);
                heartRepository.save(newHeart);
                return true;
            }
            return false;
        }
    }
}
