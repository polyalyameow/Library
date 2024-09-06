package Library;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int year;
    private int edition;
    private boolean status = true;
    private ArrayList<String> reserved;

    public Book(String title, String author, int year, int edition) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.reserved = new ArrayList<>();
    }

    public boolean loan() {
        if (this.status) {
            this.status = false;
            return true;
        }

        return false;
    }

    public boolean returnBook() {
        if (!this.status) {
            if (!reserved.isEmpty()) {
                String nextInLine = reserved.remove(0);
                this.status = false;
                System.out.println("This book is reserved to " + nextInLine);
            } else {
                this.status = true;
                System.out.println("The book has been successfully returned and is now available.");
            }
            return true;
        }
        System.out.println("The book was not loaned out. No action needed.");
        return false;
    }

    public String reserveBook(String name) {
        if (!status) {
            reserved.add(name);
            return "Reservation confirmed for " + name + ".";
        } else {
            return "The book is available and can be borrowed directly.";
        }

    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year + ", Edition: " + edition + ", Status: "
                + status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getStatus() {
        return status;
    }
}
