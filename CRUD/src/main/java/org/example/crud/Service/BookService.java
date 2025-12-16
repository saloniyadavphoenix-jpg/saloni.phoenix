package org.example.crud.Service;

import java.util.List;
import org.example.crud.Model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteBook(int id);
}
