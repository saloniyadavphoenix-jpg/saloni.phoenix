package org.example.crud.repository;

import org.example.crud.Model.Book;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JPA<Book, Integer> {
}
