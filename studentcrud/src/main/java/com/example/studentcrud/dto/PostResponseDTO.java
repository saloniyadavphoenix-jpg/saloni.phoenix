package com.example.studentcrud.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostResponseDTO {

    private Long id;
    private String title;
    private String content;

    private Long userId;
    private String userName;

    private LocalDateTime createdAt;
    private List<String> comments;
}
