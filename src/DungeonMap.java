import Rooms.AllRooms;
import Rooms.End;
import Rooms.Entry;
import Rooms.Room;

import java.util.ArrayList;

public class DungeonMap {
    /**This is basically the map itself in a two dimensional array*/
    private Room[][] rooms;
    private coord spawn;

    /**Create a new DungeonMap in a square */
    public DungeonMap(int size) {
        new DungeonMap(size, size);
    }
    /**create a new dungeon map in the shape of a rectangle, generates and adds a spawn room to the map
     * @param sizeX the desired horizontal size of the map
     * @param sizeY the desired vertical size of the map*/
    public DungeonMap(int sizeX, int sizeY) {
        rooms = new Room[sizeX][sizeY];
        spawn = new coord((int) (Math.random()*(sizeX)), (int) (Math.random()*(sizeY)));
        rooms[spawn.x()][spawn.y()] = new Entry(0);


    }
    /**A method to generate a new and random arrangement of random rooms*/
    public void GenerateRooms() {
        for(int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {

                Room room = rooms[x][y];
                if (room != null) {
                    boolean[] roomExits = room.getOpenExits();

                    if (y-1>=0&&roomExits[0] && rooms[x][y - 1] != null && !rooms[x][y - 1].getOpenExits()[2]) {
                        room.setNExit(false);
                    }
                    if (roomExits[1] && x + 1 < rooms.length && rooms[x + 1][y] != null && !rooms[x + 1][y].getOpenExits()[3]) {
                        room.setEExit(false);
                    }
                    if (roomExits[2] && y + 1 < rooms[x].length && rooms[x][y + 1] != null && !rooms[x][y + 1].getOpenExits()[0]) {
                        room.setSExit(false);
                    }
                    if (x-1>=0&&roomExits[3] && rooms[x - 1][y] != null && !rooms[x - 1][y].getOpenExits()[1]) {
                        room.setWExit(false);
                    }

                    if (roomExits[0] && y == 0) {
                        room.setNExit(false);
                    }
                    if (roomExits[1] && x == rooms.length - 1) {
                        room.setEExit(false);
                    }
                    if (roomExits[2] && y == rooms[x].length - 1) {
                        room.setSExit(false);
                    }
                    if (roomExits[3] && x == 0) {
                        room.setWExit(false);
                    }


                    if (roomExits[0]) {
                        ArrayList<Room> possibleRooms = new AllRooms().allRooms();
                        if (rooms[x][y - 1] == null) {
                            possibleRooms.removeIf(room1 -> !room1.getExits()[2]);
                            if (y - 2 <= 0) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[0]);
                            } else if (y - 2 >= 0 && rooms[x][y - 2] != null && !rooms[x][y - 2].getExits()[2]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[0]);
                            }
                            if (x-1>=0&&rooms[x - 1][y - 1] == null && x - 1 < 0) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[3]);
                            } else if (x-1>=0&&rooms[x - 1][y - 1] != null && !rooms[x - 1][y - 1].getExits()[1]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[3]);
                            }
                            if (x + 1 < rooms.length && rooms[x + 1][y - 1] == null) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[1]);
                            } else if (x + 1 < rooms.length && rooms[x + 1][y - 1] != null && !rooms[x + 1][y - 1].getExits()[3]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[1]);
                            }
                            if (!possibleRooms.isEmpty()) {
                                rooms[x][y - 1] = possibleRooms.get((int) (Math.random() * possibleRooms.size()));
                            }
                        }
                    }
                    if (roomExits[1]) {
                        ArrayList<Room> possibleRooms = new AllRooms().allRooms();

                        if (rooms[x + 1][y] == null) {
                            possibleRooms.removeIf(room1 -> !room1.getExits()[3]);
                            if (x + 2 >= rooms.length) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[1]);
                            } else if (x + 2 < rooms.length && rooms[x + 2][y] != null && !rooms[x + 2][y].getExits()[3]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[1]);
                            }
                            if (y-1<=0) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[0]);
                            } else if (x + 1 < rooms.length && rooms[x + 1][y - 1] != null && !rooms[x + 1][y - 1].getExits()[2]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[0]);
                            }
                            if (x + 1 < rooms.length && y + 1 < rooms[x].length && rooms[x + 1][y + 1] == null) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[2]);
                            } else if (x + 1 < rooms.length && y + 1 < rooms[x].length && rooms[x + 1][y + 1] != null && !rooms[x + 1][y + 1].getExits()[0]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[2]);
                            }
                            if (!possibleRooms.isEmpty()) {
                                Room randRoom = possibleRooms.get((int) (Math.random() * possibleRooms.size()));
                                rooms[x + 1][y] = randRoom;
                            }
                        }
                    }
                    if (roomExits[2]) {
                        ArrayList<Room> possibleRooms = new AllRooms().allRooms();
                        if (rooms[x][y + 1] == null) {
                            possibleRooms.removeIf(room1 -> !room1.getExits()[0]);
                            if (y + 2 >= rooms[x].length) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[2]);
                            } else if (y + 2 >= rooms[x].length && rooms[x][y + 2] != null && !rooms[x][y + 2].getExits()[0]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[2]);
                            }
                            if (x - 1 >= 0&&rooms[x - 1][y + 1] == null) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[3]);
                            } else if (rooms[x - 1][y + 1] != null && !rooms[x - 1][y + 1].getExits()[1]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[3]);
                            }
                            if (x + 1 < rooms.length && rooms[x + 1][y + 1] == null) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[1]);
                            } else if (x + 1 < rooms.length && rooms[x + 1][y + 1] != null && !rooms[x + 1][y + 1].getExits()[3]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[1]);
                            }
                            if (!possibleRooms.isEmpty()) {
                                rooms[x][y + 1] = possibleRooms.get((int) (Math.random() * possibleRooms.size()));
                            }
                        }
                    }
                    if (roomExits[3]) {
                        ArrayList<Room> possibleRooms = new AllRooms().allRooms();

                        if (rooms[x - 1][y] == null) {
                            possibleRooms.removeIf(room1 -> !room1.getExits()[1]);
                            if (x - 2 < 0) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[3]);
                            } else if (x-2 >= 0 && rooms[x - 2][y] != null && !rooms[x - 2][y].getExits()[1]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[3]);
                            }
                            if (y - 1 > 0 &&x - 1 > 0 && rooms[x - 1][y - 1] == null && y - 1 < 0) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[0]);
                            } else if (x - 1 > 0 && rooms[x - 1][y - 1] != null && !rooms[x - 1][y - 1].getExits()[2]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[0]);
                            }
                            if (x - 1 > 0 && y + 1 < rooms[x].length && rooms[x - 1][y + 1] == null) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[2]);
                            } else if (x - 1 > 0 && y + 1 < rooms[x].length && rooms[x - 1][y + 1] != null && !rooms[x - 1][y + 1].getExits()[0]) {
                                possibleRooms.removeIf(room1 -> room1.getExits()[2]);
                            }
                            if (!possibleRooms.isEmpty()) {
                                Room randRoom = possibleRooms.get((int) (Math.random() * possibleRooms.size()));
                                rooms[x - 1][y] = randRoom;
                            }

                        }
                    }
                    if (y-1>=0&&roomExits[0] && rooms[x][y - 1] != null && !rooms[x][y - 1].getOpenExits()[2]) {
                        room.setNExit(false);
                    }
                    if (roomExits[1] && x + 1 < rooms.length && rooms[x + 1][y] != null && !rooms[x + 1][y].getOpenExits()[3]) {
                        room.setEExit(false);
                    }
                    if (roomExits[2] && y + 1 < rooms[x].length && rooms[x][y + 1] != null && !rooms[x][y + 1].getOpenExits()[0]) {
                        room.setSExit(false);
                    }
                    if (x-1>=0&&roomExits[3] && rooms[x - 1][y] != null && !rooms[x - 1][y].getOpenExits()[1]) {
                        room.setWExit(false);
                    }

                    if (roomExits[0] && y == 0) {
                        room.setNExit(false);
                    }
                    if (roomExits[1] && x == rooms.length - 1) {
                        room.setEExit(false);
                    }
                    if (roomExits[2] && y == rooms[x].length - 1) {
                        room.setSExit(false);
                    }
                    if (roomExits[3] && x == 0) {
                        room.setWExit(false);
                    }
                }
            }
        }
    }
    public boolean anyOpen() {
        boolean is = false;
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                if (rooms[x][y]!=null) {
                    if (y-1>=0&&rooms[x][y].getOpenExits()[0]&&rooms[x][y-1]==null) {
                        is = true;
                    }
                    if (x+1<rooms.length&&rooms[x][y].getOpenExits()[1]&&rooms[x+1][y]==null) {
                        is = true;
                    }
                    if (y+1<rooms[x].length&&rooms[x][y].getOpenExits()[2]&&rooms[x][y+1]==null) {
                        is = true;
                    }
                    if (x-1>=0&&rooms[x][y].getOpenExits()[3]&&rooms[x-1][y]==null) {
                        is = true;
                    }
                }
            }
        }
        return is;
    }

}
