package com.example.testingdemo.service;

import com.example.testingdemo.model.Comment;
import com.example.testingdemo.repository.CommentRepository;

public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment add(Comment comment) {
        return repository.save(comment);
    }

    public Comment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }
}
