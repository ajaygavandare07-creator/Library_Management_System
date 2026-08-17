package service;

import exception.BookNotAvailableException;
import exception.BookNotFoundException;
import exception.MemberNotFoundException;
import model.Book;
import model.BorrowRecord;
import model.Member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Book> books;
    private final List<Member> members;
    private final List<BorrowRecord> borrowRecords;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        books.add(book);
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        members.add(member);
    }

    public Book findBookById(int bookId) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        throw new BookNotFoundException("Book with ID " + bookId + " not found.");
    }

    public Member findMemberById(int memberId) throws MemberNotFoundException {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        throw new MemberNotFoundException("Member with ID " + memberId + " not found.");
    }

    public void borrowBook(int bookId, int memberId)
            throws BookNotFoundException, MemberNotFoundException, BookNotAvailableException {

        Book book = findBookById(bookId);
        findMemberById(memberId);

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book with ID " + bookId + " is already borrowed.");
        }

        book.borrowBook();
        borrowRecords.add(new BorrowRecord(bookId, memberId));
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(int bookId) throws BookNotFoundException {
        Book book = findBookById(bookId);
        book.returnBook();

        for (BorrowRecord record : borrowRecords) {
            if (record.getBookId() == bookId && record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book was returned, but no active borrowing record was found.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        System.out.println("Registered Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void searchBook(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            displayBooks();
            return;
        }

        String searchText = keyword.trim().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            String title = book.getTitle() == null ? "" : book.getTitle().toLowerCase();
            String author = book.getAuthor() == null ? "" : book.getAuthor().toLowerCase();

            if (title.contains(searchText) || author.contains(searchText)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found for: " + keyword);
        }
    }

    public void displayBorrowRecords() {
        if (borrowRecords.isEmpty()) {
            System.out.println("No borrow records found.");
            return;
        }

        System.out.println("Borrow Records:");
        for (BorrowRecord record : borrowRecords) {
            System.out.println(record);
        }
    }

    public void saveData(String filePath) {
        try {
            File file = new File(filePath);
            File parent = file.getParentFile();
            if (parent != null) {
                parent.mkdirs();
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(this);
            }

            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static Library loadData(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return new Library();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof Library) {
                return (Library) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to load saved data. Starting with a new library.");
        }

        return new Library();
    }
}
