// BookService.java
package com.thehilmisu.demo.service;

import com.thehilmisu.demo.entity.Book;
import com.thehilmisu.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

	public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

	public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

	public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublicationYear(bookDetails.getPublicationYear());

        return bookRepository.save(book);
    }

	public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
