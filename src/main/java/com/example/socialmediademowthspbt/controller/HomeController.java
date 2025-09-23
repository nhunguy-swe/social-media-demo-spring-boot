package com.example.socialmediademowthspbt.controller;

import com.example.socialmediademowthspbt.service.*;
import com.example.socialmediademowthspbt.model.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @Autowired
    private FollowService followService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";

        // Lấy danh sách ID những người đã được currentUser follow
        List<Integer> followedIds = followService.getFollowedUserIds(currentUser.getId());

        // Lấy tất cả post của chính mình và của những người mình follow
        List<Post> posts = postService.getAllPostsOrderByCreatedAtDesc()
                .stream()
                .filter(p -> {
                    if (p.getUser() == null) return false;
                    boolean isOwner = p.getUser().getId() == currentUser.getId();
                    boolean isFollowed = followedIds.contains(p.getUser().getId());
                    boolean isPublic = "Public".equalsIgnoreCase(p.getStatus());
                    return isOwner || (isFollowed && isPublic);
                })
                .collect(Collectors.toList());

        // Lấy danh sách tất cả user ngoại trừ chính mình
        List<User> allOtherUsers = userService.getAllUsersExcept(currentUser.getId());

        // Lọc ra những người dùng chưa được follow
        List<User> usersToFollow = allOtherUsers.stream()
                .filter(u -> !followedIds.contains(u.getId()))
                .collect(Collectors.toList());

        // Gửi dữ liệu sang view
        model.addAttribute("user", currentUser);
        model.addAttribute("post", new Post());
        model.addAttribute("posts", posts);
        model.addAttribute("usersToFollow", usersToFollow);

        return "home";
    }
}