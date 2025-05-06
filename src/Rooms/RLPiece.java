package Rooms;

public class RLPiece extends Room{
    private boolean[] exits = new boolean[] {true, false, false, true};

    public RLPiece(int turns) {
        super(turns);
    }
}
