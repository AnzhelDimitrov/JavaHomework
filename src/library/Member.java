package library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private List<LibraryItem> borrowedItems;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void lendItem (LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem (LibraryItem item) {
        borrowedItems.remove(item);
    }
    @Override
    public String toString() {
        return
                "ID: " + getId() +
                ", Name: " + getName() +
                ", BorrowedItems: " + getBorrowedItems();
    }

}
