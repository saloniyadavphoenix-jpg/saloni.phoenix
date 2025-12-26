package com.example.dtodemo.controller;

import com.example.dtodemo.dto.*;
import com.example.dtodemo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping
    public PostDTO create(@RequestBody CreatePostRequest req) {
        return service.create(req);
    }
}
