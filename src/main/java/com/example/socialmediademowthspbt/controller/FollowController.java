package com.example.socialmediademowthspbt.controller;

import com.example.socialmediademowthspbt.service.*;
import com.example.socialmediademowthspbt.model.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


@Controller
public class FollowController {
    @Autowired
    private FollowService followService;

    @GetMapping("/follow/{id}")
    public String follow(@PathVariable("id") int id, HttpSession session) {
        User current = (User) session.getAttribute("user");
        followService.follow(current.getId(), id);
        return "redirect:/profile";
    }

    @PostMapping("/follow")
    public String followUser(@RequestParam int followedId, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";

        followService.follow(currentUser.getId(), followedId);
        return "redirect:/users";
    }
}

