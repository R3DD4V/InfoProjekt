package Rooms;

public class Corridor extends Room{

    private boolean[] exits = new boolean[] {true, false, true, false};

    public Corridor(int turns) {
        super(turns);
    }
}
