package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    @GetMapping
    public String getPosts() {
        return "Public posts";
    }

    @PostMapping
    public String createPost() {
        return "Post created";
    }

    @PutMapping
    public String updatePost() {
        return "Post updated";
    }

    @DeleteMapping
    public String deletePost() {
        return "Post deleted";
    }
}
