package Entities;

import Remnants.Remnant;
import Rooms.Room;

import java.util.*;

public class Player extends Entity{
    private Scanner reader = new Scanner(System.in);
    private Room[][] rooms;
    private int facing = 0;
    protected Remnant[] remnants;
    private List<String> enemyNames = new ArrayList<>();
    private List<String> enemyHp = new ArrayList<>();

    public Player(int pX, int pY, int pLvl, Room[][] pRooms, Remnant pRemnant) {
        super(pX, pY, pLvl);
        rooms = pRooms;
        remnants = new Remnant[3];
        remnants[0] = pRemnant;
        this.ini = 5;
        this.maxHp = 30;
        this.hp = maxHp;
        enemy = false;
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
        for (Entity e:order)  {
            List<Entity> ofThis = new ArrayList<>();
            ofThis.addAll(order);
            ofThis.removeIf(entity -> (entity.getClass()!=e.getClass()));
            if (ofThis.getFirst()==e) {
                int counter = 1;
                if (ofThis.size()>1) {
                    for (Entity d:ofThis)  {
                        d.name=d.name+counter;
                        counter+=1;
                    }
                }
            }
            if (e!=this) {
                enemyNames.add(e.name);
                enemyHp.add(e.getHpSt());
            }
        }
        order.sort(new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return Integer.compare(o2.ini, o1.ini);
            }
        });
        int round = 1;
        boolean livin = true;
        while (order.size()>1&&order.contains(this)&&livin)  {
            System.out.println("______________________");
            System.out.println("Round "+round);
            for (int i = 0; i < order.size();i++) {
                Entity a = order.get(i);
                if (a.hp<=0) {
                    order.remove(a);
                }
            }
            for (int i = 0; i<order.size()&&livin;i++)  {
                Entity e = order.get(i);
                e.myTurn(order, this);
                if (this.hp<=0)  {
                    livin = false;
                }
            }
            round+=1;
        }
    }
    @Override
    public void myTurn(List<Entity> order, Entity player)  {
        System.out.println("It is your turn, what do you want to do?");
        System.out.println("[attack] [defend] [skill]");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("attack")) {
            for (String string:enemyNames) {
                System.out.print("    "+string);
            }
            System.out.println();
            for (int i = 0; i < enemyHp.size();i++) {
                String string = enemyHp.get(i);
                System.out.print("    "+" ".repeat(enemyNames.get(i).length()-enemyNames.get(i).length()/2-(string.length()-string.length()/2))+string+" ".repeat(enemyNames.get(i).length()/2-string.length()/2));
            }
            System.out.println();
            String answer2 = scanner.nextLine();
            for (Entity d:order) {
                if (answer2.equalsIgnoreCase(d.name)) {
                    this.attack(d);
                }
            }
        }


    }

    public void attack(Entity entity) {
        int damage = 5+str;
        entity.attacked(damage);
        System.out.println("You attack "+entity.name+" for "+damage);
        System.out.println(entity.getHpSt());
    }

}
