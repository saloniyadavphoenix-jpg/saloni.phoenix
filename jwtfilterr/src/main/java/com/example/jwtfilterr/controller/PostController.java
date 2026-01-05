package com.example.jwtfilterr.controller;

import com.example.jwtfilterr.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.jwtfilterr.repository.PostRepository;


@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository repository;

    @PutMapping("/{id}")
    public Post updatePost(
            @PathVariable Long id,
            @RequestBody Post post,
            Authentication auth) {

        Post existing = repository.findById(id).orElseThrow();

        if (!existing.getUser().getUsername().equals(auth.getName())) {
            throw new AccessDeniedException("You can edit only your own post");
        }

        existing.setTitle(post.getTitle());
        existing.setContent(post.getContent());

        return repository.save(existing);
    }
}
