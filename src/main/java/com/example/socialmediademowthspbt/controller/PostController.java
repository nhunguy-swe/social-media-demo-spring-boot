package com.example.socialmediademowthspbt.controller;

import com.example.socialmediademowthspbt.service.*;
import com.example.socialmediademowthspbt.model.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String createPost(@ModelAttribute Post post, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        post.setUser(user);
        post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        postService.createPost(post);

        return "redirect:/home";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable int id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";

        Post post = postService.getPostById(id);
        if (post == null || post.getUser().getId() != currentUser.getId()) {
            // Không tìm thấy hoặc không phải chủ bài viết
            return "redirect:/home?error=unauthorized";
        }

        postService.deletePost(id);
        return "redirect:/home";
    }

    @GetMapping("/post/create")
    public String createPostForm(Model model) {
        Post post = new Post();
        post.setStatus("Public"); // Gán giá trị mặc định
        model.addAttribute("post", post);
        return "home";
    }

    @PostMapping("/post/like/{id}")
    public String likePost(@PathVariable("id") Long id) {
        Post post = postService.getPostById(id);
        post.setLikes(post.getLikes() + 1);
        postService.save(post);
        return "redirect:/home";
    }
}
