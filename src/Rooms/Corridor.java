package Rooms;

public class Corridor extends Room{
    public Corridor(int turns) {
        exits = new boolean[] {true, false, true, false};
        Turn(turns);
        openExits = exits;
    }
}
