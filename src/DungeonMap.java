import Rooms.AllRooms;
import Rooms.Entry;
import Rooms.Room;

import java.util.ArrayList;

public class DungeonMap {
    private Room[][] rooms;
    private coord spawn;

    public DungeonMap(int size) {
        new DungeonMap(size, size);
    }

    public DungeonMap(int sizeX, int sizeY) {
        rooms = new Room[sizeX][sizeY];
        spawn = new coord((int) (Math.random()*(sizeX-1)+1), (int) (Math.random()*(sizeX-1)+1));
        rooms[spawn.x()][spawn.y()] = new Entry(0);


    }

    public void GenerateRooms() {
        for(int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                Room room = rooms[x][y];
                boolean[] roomExits = room.getExits();
                ArrayList<Room> possibleRooms = new AllRooms().allRooms();
                if (roomExits[0]) {
                    if (rooms[x][y-2]==null&&y-2<0) {
                        for (Room room1:possibleRooms) {
                            if (room1.getExits()[0]) {
                                possibleRooms.remove(room1);
                            }
                        }
                    }
                }
            }
        }
    }


}
