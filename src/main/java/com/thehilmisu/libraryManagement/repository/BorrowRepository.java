package com.thehilmisu.libraryManagement.repository;

import com.thehilmisu.libraryManagement.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    List<Borrow> findByBookIdAndReturnDateIsNull(Long bookId);
}
