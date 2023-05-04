package com.egor.gavrilovblog.controllers;

import com.egor.gavrilovblog.entities.Posts;
import com.egor.gavrilovblog.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsController {
    private final PostsService service;

    public PostsController(PostsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String mainpage(Model model) {
        model.addAttribute("posts", service.findAll());
        return "index";
    }

    @GetMapping("/admin/login")
    public String adminLogin(Model model) {
        return "/admin/login";
    }

    @GetMapping("/admin/addPost")
    public String addPost(Model model) {
        return "/admin/addPost";
    }

    @PostMapping("/admin/publish")
    public String publish(Posts posts, Model model) {
        service.create(posts);
        return "redirect:/";
    }
}
