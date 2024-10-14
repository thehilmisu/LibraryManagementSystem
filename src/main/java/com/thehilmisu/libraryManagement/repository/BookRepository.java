// BookRepository.java
package com.thehilmisu.libraryManagement.repository;

import com.thehilmisu.libraryManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
