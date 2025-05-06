package Rooms;

public class TPiece extends Room{
    private boolean[] exits = new boolean[] {false, true, true, true};
    public TPiece(int turns) {
        super(turns);
    }
}
