package Rooms;

public class TPiece extends Room{
    public TPiece(int turns) {
        exits = new boolean[] {false, true, true, true};
        Turn(turns);
        openExits = exits;
    }
}
