package Rooms;

import Tiles.Tile;

/**The base class for all Rooms */
public class Room {

    /**All the tiles in the Room, currently not used
     * <p></p>
     * WIP!! */
    private Tile[][] tiles;

    /**A boolean array with a length of 4 that shows which exits the room has
     * <p></p>
     * A value of 0 corresponds to the North exit.
     * A value of 1 corresponds to the east exit.
     * A value of 2 corresponds to the south exit.
     * A value of 3 corresponds to the west exit.*/
    protected boolean[] exits = new boolean[4];



    public Room(int turns) {
        Turn(turns);
    }


    /** Sets the North Exit to a specified Truth value
     * @param pExit the boolean responsible for changing the North Exit */
    public void setNExit(boolean pExit) {
        exits[0] = pExit;
    }

    /** Sets the East Exit to a specified Truth value
     * @param pExit the boolean responsible for changing the East Exit */
    public void setEExit(boolean pExit) {
        exits[1] = pExit;
    }

    /** Sets the South Exit to a specified Truth value
     * @param pExit the boolean responsible for changing the South Exit */
    public void setSExit(boolean pExit) {
        exits[2] = pExit;
    }

    /** Sets the West Exit to a specified Truth value
     * @param pExit the boolean responsible for changing the West Exit */
    public void setWExit(boolean pExit) {
        exits[3] = pExit;
    }

    /**Returns the exits and their correspondent truth values in an Array */
    public boolean[] getExits() {
        return exits;
    }

    /**Switches the Exits of a room around as if it was turned to the right by 90°
     * @param rTurns specifies the amount of turns */
    public void Turn(int rTurns) {
        for (int i = 0; i < rTurns; i++) {
            exits = new boolean[]{exits[3], exits[0], exits[1], exits[2]};
        }
    }


}
