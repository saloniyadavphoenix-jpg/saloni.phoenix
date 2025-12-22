package com.example.studentcrud.controller;

import com.example.studentcrud.dto.PostResponseDTO;
import com.example.studentcrud.model.Post;
import com.example.studentcrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(service.savePost(post));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getPosts() {
        List<PostResponseDTO> response =
                service.getAllPosts()
                        .stream()
                        .map(service::mapToDTO)
                        .toList();

        return ResponseEntity.ok(response);
    }
}
