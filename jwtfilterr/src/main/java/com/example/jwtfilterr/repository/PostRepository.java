package com.example.jwtfilterr.repository;

import com.example.jwtfilterr.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
