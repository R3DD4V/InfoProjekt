package Rooms;

public class End extends Room{
    public End(int turns) {
        exits = new boolean[] {true, false, false, false};
        Turn(turns);
        openExits = exits;
    }
}
