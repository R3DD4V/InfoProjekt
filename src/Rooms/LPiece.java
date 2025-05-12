package Rooms;

public class LPiece extends Room{
    public LPiece(int turns) {
        exits = new boolean[] {true, true, false, false};
        Turn(turns);
        openExits = exits;
    }
}
