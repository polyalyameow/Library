package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(Scanner scanner) {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        System.out.print("Enter the year of publication: ");
        int year = scanner.nextInt();

        System.out.print("Enter the edition of the book: ");
        int edition = scanner.nextInt();

        books.add(new Book(title, author, year, edition));
        System.out.println("Book added successfully!");
    }

    public static void searchBook(Scanner scanner) {
        System.out.print("Enter the title of the book to search: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);

                if (book.getStatus()) {
                    System.out.println("Do you want to loan this book? (yes/no): ");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("yes")) {
                        if (book.loan()) {
                            System.out.println("You have successfully loaned the book.");
                        } else {
                            System.out.println("The book is already loaned out.");
                        }

                    }
                } else {
                    System.out.println("The book is currently loaned out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void listAvailableBooks() {
        boolean hasAvailableBooks = false;
        System.out.println("Available books in the library: ");
        for (Book book : books) {
            if (book.getStatus()) {
                System.out.println(book);
                System.out.println();
                hasAvailableBooks = true;
            }
        }

        if (!hasAvailableBooks) {
            System.out.println("No books available");
            System.out.println();
        }

    }

    public static void returnBook(Scanner scanner) {
        System.out.print("Enter the title of the book that you want to return: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.returnBook()) {
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("This book was not loaned out.");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void reserveBook(Scanner scanner) {
        System.out.print("Enter the title of the book that you want to return: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase((title))) {
                if (!book.getStatus()) {
                    System.out.println(
                            "Do you want to reserve: " + book.getTitle() + " " + book.getAuthor() + " (yes / no)");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("yes")) {
                        System.out.println("Please write your name");
                        String name = scanner.nextLine();
                        String confirmation = book.reserveBook(name);
                        System.out.println(confirmation);
                    }
                } else {
                    System.out.println("This book was not loaned out. You don't need to reserve it");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

}
