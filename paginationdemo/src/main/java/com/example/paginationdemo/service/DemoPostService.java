package com.example.paginationdemo.service;

import com.example.paginationdemo.model.DemoPost;
import com.example.paginationdemo.repository.DemoPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoPostService {

    private final DemoPostRepository repository;

    //Pagination only
    public Page<DemoPost> getPosts(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    //Pagination + Custom Sorting (sortBy + direction)
    public Page<DemoPost> getPostsSorted(
            int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return repository.findAll(PageRequest.of(page, size, sort));
    }

    //Spring Default Pageable (page, size, sort=createdAt,desc)
    public Page<DemoPost> getPostsWithPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
