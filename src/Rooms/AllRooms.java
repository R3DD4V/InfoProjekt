package Rooms;

import java.util.ArrayList;

public class AllRooms {
    public ArrayList<Room> allRooms() {
        ArrayList<Room> temp = new ArrayList<>();
        temp.add(new Corridor(0));
        temp.add(new Corridor(1));
        temp.add(new Corridor(2));
        temp.add(new Corridor(3));

        temp.add(new LPiece(0));
        temp.add(new LPiece(1));
        temp.add(new LPiece(2));
        temp.add(new LPiece(3));

        temp.add(new TPiece(0));
        temp.add(new TPiece(1));
        temp.add(new TPiece(2));
        temp.add(new TPiece(3));

        temp.addAll(temp);

        temp.add(new End(0));
        temp.add(new End(1));
        temp.add(new End(2));
        temp.add(new End(3));

        return temp;
    }
}
