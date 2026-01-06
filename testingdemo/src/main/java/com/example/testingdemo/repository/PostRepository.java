package com.example.testingdemo.repository;

import com.example.testingdemo.model.Post;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
}
