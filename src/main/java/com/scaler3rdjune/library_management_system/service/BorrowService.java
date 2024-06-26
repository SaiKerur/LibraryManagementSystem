package com.scaler3rdjune.library_management_system.service;

import com.scaler3rdjune.library_management_system.model.Book;
import com.scaler3rdjune.library_management_system.model.BorrowRecord;
import com.scaler3rdjune.library_management_system.model.User;
import com.scaler3rdjune.library_management_system.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public void addUserBorrowHistory(User user, Book book) {
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setUser(user);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(LocalDate.now());
        borrowRecord.setReturned(false);

        borrowRecordRepository.save(borrowRecord);
    }

    public List<BorrowRecord> getUserBorrowHistory(User user) {
        return borrowRecordRepository.findByUser(user);
    }
}
