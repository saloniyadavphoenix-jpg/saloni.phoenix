package com.example.dtodemo.dto;

import lombok.Data;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private UserSummaryDTO user;
}
