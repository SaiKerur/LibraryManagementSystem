package com.scaler3rdjune.library_management_system.controller;

import com.scaler3rdjune.library_management_system.model.Book;
import com.scaler3rdjune.library_management_system.model.BorrowRecord;
import com.scaler3rdjune.library_management_system.model.User;
import com.scaler3rdjune.library_management_system.repository.BookRepository;
import com.scaler3rdjune.library_management_system.repository.UserRepository;
import com.scaler3rdjune.library_management_system.service.BorrowService;
import com.scaler3rdjune.library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public void addBorrowRecord(@RequestParam String username, @RequestParam Long bookId) {
        User user = userService.getUserByUsername(username);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        borrowService.addUserBorrowHistory(user, book);
    }
    
    @GetMapping("/history")
    public List<BorrowRecord> getUserBorrowHistory(@RequestParam String username) {
        // For simplicity, assume authentication is already done
        User user = userRepository.findByUsername(username);
        return borrowService.getUserBorrowHistory(user);
    }
}

