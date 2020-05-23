package com.example.demo.Repo;

import com.example.demo.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Repo {

    @Autowired
    JdbcTemplate template;

    public List<Book> fetchAll() {
        String sql = "SELECT * FROM BookStoreWebsite.Books";
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        return template.query(sql, rowMapper);
    }

    public Book addBook(Book book) {

        String sql = "INSERT INTO BookStoreWebsite.Books (BookId, AuthorFirstName, AuthorLastName, Title, ISBN) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, book.getBookId(), book.getAuthorFirstName(), book.getAuthorLastName(), book.getTitle(), book.getISBN());
        return null;
    }

    public Book findBook(int bookId) {

        String sql = "SELECT * FROM BookStoreWebsite.Books WHERE BookId = ?";
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        Book book = template.queryForObject(sql, rowMapper, bookId);
        return book;
    }

    public Boolean deleteBook(int bookId) {

        String sql = "DELETE FROM BookStoreWebsite.Books WHERE BookId = ?";
        return template.update(sql, bookId) > 0;
    }

    public Book updateBook(Book book, int bookId) {

        String sql = "UPDATE BookStoreWebsite.Books SET AuthorFirstName = ?, AuthorLastName = ?, Title = ?, ISBN = ? WHERE BookId = ?";
        template.update(sql, book.getAuthorFirstName(), book.getAuthorLastName(), book.getTitle(), book.getISBN(), bookId);
        return null;
    }

    public List<Book> findAnyBook(String keyword) {
        //String sql = "SELECT * FROM BookStoreWebsite.Books WHERE BookId LIKE '%?%' OR AuthorFirstName LIKE '%?%' OR AuthorLastName LIKE '%?%' OR Title LIKE '%?%'OR ISBN LIKE '%?%' ";
        String sql = "SELECT * FROM BookStoreWebsite.Books WHERE AuthorFirstName LIKE '" + keyword +"%' OR AuthorLastName LIKE '" + keyword + "%' OR Title LIKE '" +
                keyword + "%'";

        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);

        return template.query(sql, rowMapper);
        }

}