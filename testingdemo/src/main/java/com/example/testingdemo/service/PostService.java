package com.example.testingdemo.service;

import com.example.testingdemo.model.Post;
import com.example.testingdemo.repository.PostRepository;

public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post create(Post post) {
        return repository.save(post);
    }
}
