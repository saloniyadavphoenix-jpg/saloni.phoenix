package org.example.crud.Service;

import java.util.List;

import org.example.crud.Model.Book;
import org.example.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repo;

    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return repo.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return repo.save(book);
    }

    @Override
    public void deleteBook(int id) {
        repo.deleteById(id);
    }
}
