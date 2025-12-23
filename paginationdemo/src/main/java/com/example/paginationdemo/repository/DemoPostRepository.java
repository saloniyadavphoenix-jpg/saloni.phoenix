package com.example.paginationdemo.repository;

import com.example.paginationdemo.model.DemoPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoPostRepository extends JpaRepository<DemoPost, Long> {

    Page<DemoPost> findAll(Pageable pageable);
}
