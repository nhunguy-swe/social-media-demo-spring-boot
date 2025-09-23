package com.example.socialmediademowthspbt.repository;

import com.example.socialmediademowthspbt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.id <> :userId")
    List<User> findAllExcept(@Param("userId") int userId);
}
