package com.example.socialmediademowthspbt.service;

import com.example.socialmediademowthspbt.model.Follow;
import com.example.socialmediademowthspbt.repository.FollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class FollowService {
    @Autowired
    private FollowRepo followRepo;

    public void follow(int followerId, int followeeId) {
        Follow follow = new Follow();
        follow.setFollowedUserId(followeeId);
        follow.setFollowingUserId(followerId);
        follow.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        followRepo.save(follow);
    }

    public List<Integer> getFollowedUserIds(int userId) {
        return followRepo.findFollowedUserIds(userId);
    }
}