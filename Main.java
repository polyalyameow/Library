package Library;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a book to the library");
            System.out.println("2. Search for a book by name");
            System.out.println("3. List all available books");
            System.out.println("4. Return a book");
            System.out.println("5. Quit");
            System.out.println("6. Reserve a book");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Library.addBook(scanner);
                        break;
                    case 2:
                        Library.searchBook(scanner);
                        break;
                    case 3:
                        Library.listAvailableBooks();
                        break;
                    case 4:
                        Library.returnBook(scanner);
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        break;
                    case 6:
                        Library.reserveBook(scanner);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 5);

        scanner.close();
    }
}
