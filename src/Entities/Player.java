package Entities;

import Remnants.Remnant;
import Rooms.Room;

import java.util.Objects;
import java.util.Scanner;

public class Player extends Entity{
    private Scanner reader = new Scanner(System.in);
    private Room[][] rooms;
    private int facing = 0;
    protected Remnant[] remnants;

    public Player(int pX, int pY, int pLvl, Room[][] pRooms, Remnant pRemnant) {
        super(pX, pY, pLvl);
        rooms = pRooms;
        remnants = new Remnant[3];
        remnants[0] = pRemnant;
    }

    public void move() {
        boolean input = true;
        while (input) {
            boolean[] directions = rooms[RoomX][RoomY].getOpenExits();
            for (int i = 0; i < facing; i++) {
                directions = new boolean[] {directions[1], directions[2], directions[3], directions[0]};
            }
            System.out.println("In what direction do you want to go?");
            System.out.println((directions[0] ? "[Forward] " : "") + (directions[1] ? "[Right] " : "") + (directions[2] ? "[Back] " : "") + (directions[3] ? "[Left]" : ""));
            String in = reader.nextLine();
            if (Objects.equals(in, "forward") &&directions[0]) {
                if (facing==0) {
                    RoomY-=1;
                }
                else if (facing==1) {
                    RoomX+=1;
                } else if (facing==2) {
                    RoomY+=1;
                } else if (facing==3) {
                    RoomX-=1;
                }
                input = false;
            } else if (Objects.equals(in, "right") &&directions[1]) {
                if (facing==0) {
                    RoomX+=1;
                }
                else if (facing==1) {
                    RoomY+=1;
                } else if (facing==2) {
                    RoomX-=1;
                } else if (facing==3) {
                    RoomY-=1;
                }
                facing+=1;
                input = false;
            } else if (Objects.equals(in, "back") &&directions[2]) {
                if (facing==0) {
                    RoomY+=1;
                }
                else if (facing==1) {
                    RoomX-=1;
                } else if (facing==2) {
                    RoomY-=1;
                } else if (facing==3) {
                    RoomX+=1;
                }
                facing+=2;
                input = false;
            } else if (Objects.equals(in, "left") &&directions[3]) {
                if (facing==0) {
                    RoomX-=1;
                }
                else if (facing==1) {
                    RoomY-=1;
                } else if (facing==2) {
                    RoomX+=1;
                } else if (facing==3) {
                    RoomY+=1;
                }
                facing+=3;
                input = false;
            }
            while (facing > 3) {
                facing -= 4;
            }

        }
        System.out.println(RoomX+" "+RoomY);
        enterRoom(rooms[RoomX][RoomY]);
    }

    public void enterRoom(Room room) {
        for (int i = 0; i < room.getType().getTraits().length; i++) {
            if (room.getType().getTraits()[i]) {
                Remnant remnant = remnants[(int) (Math.random() * remnants.length)];
                while (remnant == null) {
                    remnant = remnants[(int) (Math.random() * remnants.length)];
                }

                String line = remnant.getLines()[i][(int) (Math.random() * remnant.getLines()[i].length)];
                System.out.println(line);
            }
        }
    }

    public void combat(Monster[] enemies) {

    }

}
