package com.example.testingdemo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String content;
}
