package com.scaler3rdjune.library_management_system.repository;

import com.scaler3rdjune.library_management_system.model.BorrowRecord;
import com.scaler3rdjune.library_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByUser(User user);
}
