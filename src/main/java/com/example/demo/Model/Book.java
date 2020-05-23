package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonTypeId;
import javax.persistence.Column;


    @Entity
    public class Book {

        @Id
        private int bookId;
        private String authorFirstName;
        private String authorLastName;
        private String title;
        private long ISBN;

        public Book() {
        }

        public Book(int bookId, String authorFirstName, String authorLastName, String title, long ISBN) {
            this.bookId = bookId;
            this.authorFirstName = authorFirstName;
            this.authorLastName = authorLastName;
            this.title = title;
            this.ISBN = ISBN;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public void setAuthorFirstName(String authorFirstName) {
            this.authorFirstName = authorFirstName;
        }

        public void setAuthorLastName(String authorLastName) {
            this.authorLastName = authorLastName;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setISBN(long ISBN) {
            this.ISBN = ISBN;
        }

        public int getBookId() {
            return bookId;
        }

        public String getAuthorFirstName() {
            return authorFirstName;
        }

        public String getAuthorLastName() {
            return authorLastName;
        }

        public String getTitle() {
            return title;
        }

        public long getISBN() {
            return ISBN;
        }

    }

