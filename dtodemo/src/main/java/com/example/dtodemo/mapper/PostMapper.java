package com.example.dtodemo.mapper;

import com.example.dtodemo.dto.PostDTO;
import com.example.dtodemo.model.Post;

public class PostMapper {

    public static PostDTO toDTO(Post post) {

        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setUser(UserMapper.toSummary(post.getUser()));

        return dto;
    }
}
