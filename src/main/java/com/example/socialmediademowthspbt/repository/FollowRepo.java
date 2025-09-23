package com.example.socialmediademowthspbt.repository;

import com.example.socialmediademowthspbt.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FollowRepo extends JpaRepository<Follow, Integer> {
    @Query("SELECT f.followedUserId FROM Follow f WHERE f.followingUserId = :userId")
    List<Integer> findFollowedUserIds(@Param("userId") int userId);
}
