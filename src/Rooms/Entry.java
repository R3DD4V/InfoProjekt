package Rooms;

public class Entry extends Room {
    private boolean[] exits = new boolean[] {true, true, true, true};

    public Entry(int turns) {
        super(turns);
    }
}
