package com.example.studentcrud.repository;

import com.example.studentcrud.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
