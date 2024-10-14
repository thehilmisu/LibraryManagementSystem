// BorrowService.java
package com.thehilmisu.demo.service;

import com.thehilmisu.demo.entity.Borrow;
import com.thehilmisu.demo.entity.Book;
import com.thehilmisu.demo.entity.User;
import com.thehilmisu.demo.repository.BorrowRepository;
import com.thehilmisu.demo.repository.BookRepository;
import com.thehilmisu.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    public Borrow borrowBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!isBookAvailable(bookId)) {
            throw new RuntimeException("Book is already borrowed");
        }

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setUser(user);
        borrow.setBorrowDate(LocalDate.now());

        return borrowRepository.save(borrow);
    }

    public boolean isBookAvailable(Long bookId) {
        return borrowRepository.findByBookIdAndReturnDateIsNull(bookId).isEmpty();
    }

    public Borrow returnBook(Long borrowId) {
        Borrow borrow = borrowRepository.findById(borrowId)
            .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        borrow.setReturnDate(LocalDate.now());
        return borrowRepository.save(borrow);
    }
}
