package com.example.paginationdemo.controller;

import com.example.paginationdemo.model.DemoPost;
import com.example.paginationdemo.service.DemoPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo-posts")
@RequiredArgsConstructor
public class DemoPostController {

    private final DemoPostService service;

    //Pagination only
    // GET /api/demo-posts?page=0&size=10
    @GetMapping
    public ResponseEntity<Page<DemoPost>> getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(service.getPosts(page, size));
    }

    //Pagination + Custom Sorting
    // GET /api/demo-posts/sort?page=0&size=10&sortBy=createdAt&direction=desc
    @GetMapping("/sort")
    public ResponseEntity<Page<DemoPost>> getSortedPosts(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        return ResponseEntity.ok(
                service.getPostsSorted(page, size, sortBy, direction)
        );
    }

    //Spring Default Pageable Sorting
    // GET /api/demo-posts/paged?page=0&size=10&sort=createdAt,desc
    @GetMapping("/paged")
    public ResponseEntity<Page<DemoPost>> getPostsWithPageable(Pageable pageable) {
        return ResponseEntity.ok(service.getPostsWithPageable(pageable));
    }

    //Mini Task: Sort by title A–Z
    // GET /api/demo-posts/title-asc
    @GetMapping("/title-asc")
    public ResponseEntity<Page<DemoPost>> sortByTitleAsc() {
        return ResponseEntity.ok(
                service.getPostsSorted(0, 10, "title", "asc")
        );
    }
}