// UserService.java
package com.thehilmisu.libraryManagement.service;

import com.thehilmisu.libraryManagement.entity.User;
import com.thehilmisu.libraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

	public User saveUser(User user) {
        return userRepository.save(user);
    }

	public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

	public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

	public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
