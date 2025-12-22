package com.example.studentcrud.service;

import com.example.studentcrud.dto.PostResponseDTO;
import com.example.studentcrud.model.Comment;
import com.example.studentcrud.model.Post;
import com.example.studentcrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Post savePost(Post post) {
        return repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    // ENTITY → DTO
    public PostResponseDTO mapToDTO(Post post) {
        PostResponseDTO dto = new PostResponseDTO();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());

        if (post.getUser() != null) {
            dto.setUserId(post.getUser().getId());
            dto.setUserName(post.getUser().getName());
        }

        if (post.getComments() != null) {
            dto.setComments(
                    post.getComments()
                            .stream()
                            .map(Comment::getContent)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
