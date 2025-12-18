package com.example.studentcrud.controller;

import com.example.studentcrud.model.Post;
import com.example.studentcrud.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(service.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id,
                                           @RequestBody Post post) {
        return ResponseEntity.ok(service.updatePost(id, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
