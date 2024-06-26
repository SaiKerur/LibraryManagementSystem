package com.scaler3rdjune.library_management_system.repository;

import com.scaler3rdjune.library_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

