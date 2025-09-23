package com.example.socialmediademowthspbt.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "follows")
@IdClass(FollowId.class)
public class Follow {
    @Id
    @Column(name = "following_user_id")
    private int followingUserId;

    @Id
    @Column(name = "followed_user_id")
    private int followedUserId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public int getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(int followingUserId) {
        this.followingUserId = followingUserId;
    }

    public int getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(int followedUserId) {
        this.followedUserId = followedUserId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
