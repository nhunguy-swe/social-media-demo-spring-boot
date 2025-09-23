package com.example.socialmediademowthspbt.service;

import com.example.socialmediademowthspbt.model.*;
import com.example.socialmediademowthspbt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public void createPost(Post post) {
        postRepo.save(post);
    }

    public List<Post> getPostsByUser(int userId) {
        return postRepo.findByUserId(userId);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public void deletePost(int id) {
        postRepo.deleteById((long) id);
    }

    public Post getPostById(int id) {
        return postRepo.findById((long) id).orElse(null);
    }

    public List<Post> getAllPostsOrderByCreatedAtDesc() {
        return postRepo.findAllByOrderByCreatedAtDesc();
    }

    public Post getPostById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    public void save(Post post) {
        postRepo.save(post);
    }
}
