package com.example.socialmediademowthspbt.model;

import java.io.Serializable;
import java.util.Objects;

public class FollowId implements Serializable {
    private int followingUserId;
    private int followedUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowId followId = (FollowId) o;
        return followingUserId == followId.followingUserId && followedUserId == followId.followedUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(followingUserId, followedUserId);
    }
}
