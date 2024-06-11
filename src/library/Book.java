package library;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int id, boolean available, String author) {
        super(title, id, available);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return
                "title " + getTitle() +
                ", ID: " + getId() +
                ", Available: " + isAvailable() +
                ", Author: " + getAuthor();
    }
}
