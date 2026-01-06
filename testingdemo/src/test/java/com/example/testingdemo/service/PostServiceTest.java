package com.example.testingdemo.service;

import com.example.testingdemo.model.Post;
import com.example.testingdemo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository repository;

    @InjectMocks
    private PostService service;

    @Test
    void createPostTest() {
        Post post = new Post(1L, "JUnit");
        when(repository.save(any(Post.class))).thenReturn(post);

        Post saved = service.create(post);

        assertEquals("JUnit", saved.getTitle());
    }
}
