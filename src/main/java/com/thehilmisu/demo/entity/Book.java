// Book.java
package com.thehilmisu.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<Borrow> borrows;

    public Book() {
    }

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

	public String getTitle() {
        return title;
    }

	public void setTitle(String title) {
        this.title = title;
    }

	public String getAuthor() {
        return author;
    }

	public void setAuthor(String author) {
        this.author = author;
    }

	public String getIsbn() {
        return isbn;
    }

	public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

	public int getPublicationYear() {
        return publicationYear;
    }

	public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }
}
