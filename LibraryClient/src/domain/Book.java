/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Book implements Serializable {
    private String ISBN;
    private String bookAuthor;
    private String bookTitle;
    private String bookCategory;
    private String shelfNumber;
    private String available;

    public Book() {
    }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String ISBN, String bookAuthor, String bookTitle, String bookCategory, String shelfNumber, String available) {
        this.ISBN = ISBN;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.shelfNumber = shelfNumber;
        this.available = available;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public String getAvailable() {
        return available;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN=" + ISBN + ", bookAuthor=" + bookAuthor + ", bookTitle=" + bookTitle + ", bookCategory=" + bookCategory + ", shelfNumber=" + shelfNumber + ", available=" + available + '}';
    }
}
