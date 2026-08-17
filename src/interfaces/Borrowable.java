package interfaces;

public interface Borrowable {
    void borrowBook();

    void returnBook();

    boolean isAvailable();
}
