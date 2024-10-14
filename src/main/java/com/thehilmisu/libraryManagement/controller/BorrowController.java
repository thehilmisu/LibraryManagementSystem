// BorrowController.java
package com.thehilmisu.libraryManagement.controller;

import com.thehilmisu.libraryManagement.entity.Borrow;
import com.thehilmisu.libraryManagement.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

	@PostMapping
    public Borrow createBorrow(@RequestBody Borrow borrow) {
        return borrowService.saveBorrow(borrow);
    }

	@GetMapping
    public List<Borrow> getAllBorrows() {
        return borrowService.getAllBorrows();
    }

	@PostMapping("/borrow")
    public Borrow borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return borrowService.borrowBook(userId, bookId);
    }

	@PostMapping("/return/{id}")
    public Borrow returnBook(@PathVariable Long id) {
        return borrowService.returnBook(id);
    }
    
}
