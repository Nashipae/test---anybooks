package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    Repo bookRepo;

    public List<Book> fetchAll(){
        return bookRepo.fetchAll();
    }

    public Book addBook(Book book){
        return bookRepo.addBook(book);
    }

    public Book findBook(int bookId){
        return bookRepo.findBook(bookId);
    }

    public Boolean deleteBook(int bookId){
        return bookRepo.deleteBook(bookId);
    }

    public Book updateBook(Book book, int bookId){
        return bookRepo.updateBook(book, bookId);
    }

    public List<Book> findAnyBook(String keyword){
        return bookRepo.findAnyBook(keyword);
    }

}
