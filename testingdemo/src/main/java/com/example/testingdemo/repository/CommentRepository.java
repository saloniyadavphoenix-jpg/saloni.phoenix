package com.example.testingdemo.repository;

import com.example.testingdemo.model.Comment;
import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);
    Optional<Comment> findById(Long id);
}
