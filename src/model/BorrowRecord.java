package model;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = LocalDate.now();
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                " | Member ID: " + memberId +
                " | Borrowed: " + borrowDate +
                " | Returned: " +
                (returnDate == null ? "Not Returned" : returnDate);
    }
}
