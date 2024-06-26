package com.scaler3rdjune.library_management_system.service;

import com.scaler3rdjune.library_management_system.model.User;
import com.scaler3rdjune.library_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // You can add validation or additional logic here
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Additional methods for updating, deleting users, etc.
}
