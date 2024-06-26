package com.scaler3rdjune.library_management_system.service;

import com.scaler3rdjune.library_management_system.model.Book;
import com.scaler3rdjune.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String title) {
        if (title == null) {
            return bookRepository.findAll();
        } else {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        }
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
