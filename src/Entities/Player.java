package Entities;

import Remnants.Remnant;
import Rooms.Room;

import java.util.*;

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
        this.ini = 5;
        this.maxHp = 30;
        this.hp = maxHp;
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
        List<Entity> order = new ArrayList<>();
        order.addFirst(this);
        order.addAll(List.of(enemies));
        /*for (int i = 0; i < enemies.length; i++) {
            boolean added = false;
            for (int e = 0; e < order.size()&&!added; e++) {
                if ( (order.get(e) == null || order.get(e) != null && enemies[i].ini > order.get(e).ini) && (e+1 >= order.size() || (e+1 < order.size() && (order.get(e + 1) == null || (order.get(e + 1) != null && enemies[i].ini > order.get(e + 1).ini))))) {
                    for (int d = order.size()-1; d > e; d--) {
                        order.set(d, order.get(d - 1));
                    }
                    order.add(e, enemies[i]);
                    added = true;
                }
            }
        }*/
        order.sort(new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return Integer.compare(o2.ini, o1.ini);
            }
        });
        int round = 0;
        while (order.size()>1&&order.contains(this))  {
            System.out.println("______________________");
            System.out.println("Round "+round);
            for (int i = 0; i < order.size();i++) {
                Entity a = order.get(i);
                if (a.hp<=0) {
                    order.remove(a);
                }
            }
            for (Entity e:order)  {
                e.myTurn();
            }
            round+=1;
        }
    }
    @Override
    public void myTurn()  {
        System.out.println("Player Turn");
        this.hp-=1;
    }

}
