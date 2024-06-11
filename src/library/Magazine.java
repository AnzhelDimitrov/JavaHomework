package library;

public class Magazine extends LibraryItem {
    private int editionNum;

    public Magazine(String title, int id, boolean available, int availableCount, int editionNum) {
        super(title, id, available);
        this.editionNum = editionNum;
    }

    public int getEditionNum() {
        return editionNum;
    }

    @Override
    public String toString() {
        return
                "title " + getTitle() +
                ", ID: " + getId() +
                ", Available: " + isAvailable() +
                ", Edition: " + getEditionNum();
    }
}
