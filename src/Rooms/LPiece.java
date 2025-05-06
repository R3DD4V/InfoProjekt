package Rooms;

public class LPiece extends Room{
    private boolean[] exits = new boolean[] {true, true, false, false};
    public LPiece(int turns) {
        super(turns);
    }
}
