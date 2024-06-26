package com.scaler3rdjune.library_management_system.repository;

import com.scaler3rdjune.library_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}