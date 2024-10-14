// Borrow.java
package com.thehilmisu.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("borrows")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("borrows")
    private Book book;

    public Borrow() {
    }

    public Borrow(LocalDate borrowDate, User user, Book book) {
        this.borrowDate = borrowDate;
        this.user = user;
        this.book = book;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

	public LocalDate getBorrowDate() {
        return borrowDate;
    }

	public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

	public LocalDate getReturnDate() {
        return returnDate;
    }

	public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

	public User getUser() {
        return user;
    }

	public void setUser(User user) {
        this.user = user;
    }

	public Book getBook() {
        return book;
    }

	public void setBook(Book book) {
        this.book = book;
    }
}
