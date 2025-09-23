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
public class AuthController {
    @Autowired private UserService userService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, HttpSession session) {
        User user = userService.findByUsername(username);

        if (user != null) {
            // Đăng nhập thành công
            session.setAttribute("user", user);
            return "redirect:/home"; // Trang sau đăng nhập
        } else {
            // Chuyển sang trang đăng ký nếu không tìm thấy
            return "redirect:/register";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, Model model) {
        // Kiểm tra username đã tồn tại chưa
        if (userService.existsByUsername(username)) {
            model.addAttribute("error", "Username already exists!");
            return "register"; // quay lại form đăng ký
        }

        // Nếu chưa tồn tại, thì tạo user mới
        User user = new User();
        user.setUsername(username);
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userService.register(user);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa toàn bộ session (bao gồm user đang đăng nhập)
        return "redirect:/login"; // Quay lại trang login
    }
}

