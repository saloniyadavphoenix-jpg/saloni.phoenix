package com.example.dtodemo.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
    private Long userId;
}
