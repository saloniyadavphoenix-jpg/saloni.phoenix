package com.example.testingdemo.service;

import com.example.testingdemo.model.Comment;
import com.example.testingdemo.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentRepository repository;

    @InjectMocks
    private CommentService service;

    @Test
    void addComment() {
        Comment c = new Comment(1L, "Nice");
        when(repository.save(any(Comment.class))).thenReturn(c);

        Comment result = service.add(c);

        assertEquals("Nice", result.getContent());
    }

    @Test
    void getCommentFound() {
        Comment c = new Comment(1L, "Ok");
        when(repository.findById(1L)).thenReturn(Optional.of(c));

        Comment result = service.getById(1L);

        assertNotNull(result);
        assertEquals("Ok", result.getContent());
    }

    @Test
    void getCommentNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> service.getById(1L));
    }

    @Test
    void saveCalledOnce() {
        Comment c = new Comment(1L, "Test");
        when(repository.save(any(Comment.class))).thenReturn(c);//se repository ka behavior define kiya

        service.add(c);

        verify(repository, times(1)).save(any(Comment.class)); //se check kiya ki method kitni baar call hui
    }

    @Test
    void repositoryNeverNull() {
        assertNotNull(repository);
    }
}