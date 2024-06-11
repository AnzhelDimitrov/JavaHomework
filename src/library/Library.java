package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<LibraryItem> items;
    List<Member> members;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addItem (LibraryItem item) {
        items.add(item);
    }

    public void removeItem (LibraryItem item) {
        items.remove(item);
    }

    public void addMember (Member member) {
        members.add(member);
    }

    public void removeMember (Member member) {
        members.remove(member);
    }

    public boolean lendItem (int itemId, int memberId) {
        for (LibraryItem item : items) {
            if (item.getId() == itemId && item.isAvailable()) {
                for (Member member : members) {
                    if (member.getId() == memberId) {
                        item.setAvailable(false);
                        member.lendItem(item);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean returnItem (int itemId, int memberId) {
        for (LibraryItem item : items) {
            if (item.getId() == itemId) {
                for (Member member : members) {
                    if (member.getId() == memberId) {
                        item.setAvailable(true);
                        member.returnItem(item);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
