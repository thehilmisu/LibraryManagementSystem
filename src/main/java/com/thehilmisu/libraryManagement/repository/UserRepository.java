package com.thehilmisu.libraryManagement.repository;

import com.thehilmisu.libraryManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
