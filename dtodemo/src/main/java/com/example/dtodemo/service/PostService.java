package com.example.dtodemo.service;

import com.example.dtodemo.dto.CreatePostRequest;
import com.example.dtodemo.dto.PostDTO;
import com.example.dtodemo.mapper.PostMapper;
import com.example.dtodemo.model.Post;
import com.example.dtodemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    public PostDTO create(CreatePostRequest req) {

        //Dummy user (simulate DB)
        User user = new User();
        user.setId(req.getUserId());
        user.setUsername("saloni");

        //Request → Entity
        Post post = new Post();
        post.setId(1L);                       // simulate DB id
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        post.setUser(user);

        //Entity → DTO
        return PostMapper.toDTO(post);
    }
}
