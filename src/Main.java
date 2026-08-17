import model.*;
import service.Library;
import exception.*;

import java.util.Scanner;

public class Main {

    private static final String DATA_FILE =
            "data/library.dat";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library =
                Library.loadData(DATA_FILE);

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Add Book");
            System.out.println("2. Add Student Member");
            System.out.println("3. Add Faculty Member");
            System.out.println("4. Display Books");
            System.out.println("5. Display Members");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Search Book");
            System.out.println("9. Display Borrow Records");
            System.out.println("10. Save Data");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );

                choice = -1;
            }

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(
                                scanner.nextLine()
                        );

                        System.out.print("Enter Book Title: ");
                        String title =
                                scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author =
                                scanner.nextLine();

                        library.addBook(
                                new Book(
                                        bookId,
                                        title,
                                        author
                                )
                        );

                        break;

                    case 2:

                        System.out.print("Enter Member ID: ");
                        int studentId =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        System.out.print("Enter Student Name: ");
                        String studentName =
                                scanner.nextLine();

                        library.addMember(
                                new StudentMember(
                                        studentId,
                                        studentName
                                )
                        );

                        break;

                    case 3:

                        System.out.print("Enter Member ID: ");
                        int facultyId =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        System.out.print("Enter Faculty Name: ");
                        String facultyName =
                                scanner.nextLine();

                        library.addMember(
                                new FacultyMember(
                                        facultyId,
                                        facultyName
                                )
                        );

                        break;

                    case 4:

                        library.displayBooks();

                        break;

                    case 5:

                        library.displayMembers();

                        break;

                    case 6:

                        System.out.print("Enter Book ID: ");
                        int borrowBookId =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        System.out.print("Enter Member ID: ");
                        int borrowMemberId =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        library.borrowBook(
                                borrowBookId,
                                borrowMemberId
                        );

                        break;

                    case 7:

                        System.out.print("Enter Book ID: ");
                        int returnBookId =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        library.returnBook(
                                returnBookId
                        );

                        break;

                    case 8:

                        System.out.print(
                                "Enter title or author: "
                        );

                        String keyword =
                                scanner.nextLine();

                        library.searchBook(keyword);

                        break;

                    case 9:

                        library.displayBorrowRecords();

                        break;

                    case 10:

                        library.saveData(DATA_FILE);

                        break;

                    case 0:

                        library.saveData(DATA_FILE);

                        System.out.println(
                                "Thank you for using "
                                        + "Library Management System."
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (
                    BookNotFoundException |
                    MemberNotFoundException |
                    BookNotAvailableException e
            ) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter valid numeric input."
                );
            }

        } while (choice != 0);

        scanner.close();
    }
}