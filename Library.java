import java.io.*;
import java.util.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.txt";

    public Library() {
        loadFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        saveToFile();
        System.out.println("Book added successfully.");
    }

    public void rentBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && b.isAvailable()) {
                b.rentBook();
                saveToFile();
                System.out.println("Book rented successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && !b.isAvailable()) {
                b.returnBook();
                saveToFile();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid return.");
    }

    public void displayBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                bw.write(b.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}
