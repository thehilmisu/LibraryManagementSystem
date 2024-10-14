package com.thehilmisu.demo.repository;

import com.thehilmisu.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
