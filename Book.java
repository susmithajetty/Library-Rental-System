import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + available;
    }

    public static Book fromString(String line) {
        String[] data = line.split(",");
        Book b = new Book(
                Integer.parseInt(data[0]),
                data[1],
                data[2]
        );
        b.available = Boolean.parseBoolean(data[3]);
        return b;
    }
}
