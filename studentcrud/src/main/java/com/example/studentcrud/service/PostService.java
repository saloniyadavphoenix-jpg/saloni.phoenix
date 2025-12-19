package com.example.studentcrud.service;

import com.example.studentcrud.model.Post;
import com.example.studentcrud.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    // ✅ FIXED METHOD
    public Post updatePost(Long id, Post post) {
        Post existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(post.getTitle());
            existing.setContent(post.getContent());
            existing.setUser(post.getUser()); // 🔥 CHANGE HERE
            return repository.save(existing);
        }
        return null;
    }

    public void deletePost(Long id) {
        repository.deleteById(id);
    }
}
