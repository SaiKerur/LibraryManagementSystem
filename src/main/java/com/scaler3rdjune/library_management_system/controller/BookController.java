package com.scaler3rdjune.library_management_system.controller;

import com.scaler3rdjune.library_management_system.service.BookService;
import com.scaler3rdjune.library_management_system.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @GetMapping
    public List<Book> searchBooks(@RequestParam(required = false) String title) {
        return bookService.searchBooks(title);
    }
}
