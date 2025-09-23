package com.example.socialmediademowthspbt.repository;

import com.example.socialmediademowthspbt.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    String sql = "SELECT * FROM posts WHERE id = ?";
    List<Post> findByUserId(int userId);
    List<Post> findAll();
    List<Post> findAllByOrderByCreatedAtDesc();
    Post save(Post post);
}
