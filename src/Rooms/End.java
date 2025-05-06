package Rooms;

public class End extends Room{
    private boolean[] exits = new boolean[] {true, false, false, false};
    public End(int turns) {
        super(turns);
    }
}
