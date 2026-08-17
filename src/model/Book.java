package model;

import interfaces.Borrowable;

public class Book extends LibraryItem implements Borrowable {

    private static final long serialVersionUID = 1L;

    private final int bookId;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        super(String.valueOf(bookId), title);
        this.bookId = bookId;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return super.getTitle();
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void borrowBook() {
        available = false;
    }

    @Override
    public void returnBook() {
        available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                " | Title: " + getTitle() +
                " | Author: " + author +
                " | Status: " +
                (available ? "Available" : "Borrowed");
    }
}
