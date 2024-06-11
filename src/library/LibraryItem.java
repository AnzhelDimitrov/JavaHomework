package library;

public class LibraryItem {
    private String title;
    private int id;
    private boolean available;

    public LibraryItem(String title, int id, boolean available) {
        this.title = title;
        this.id = id;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}


