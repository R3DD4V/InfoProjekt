package Rooms;

public class Entry extends Room {

    public Entry(int turns) {
        exits = new boolean[] {true, true, true, true};
        Turn(turns);
        openExits = exits;
    }
}
