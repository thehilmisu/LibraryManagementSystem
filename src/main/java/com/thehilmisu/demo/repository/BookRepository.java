// BookRepository.java
package com.thehilmisu.demo.repository;

import com.thehilmisu.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
