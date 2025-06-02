package Entities;

public class Entity {
    protected int RoomX;
    protected int RoomY;

    protected String name;
    protected int lvl = 0;
    protected int hp = 0;
    protected int maxHp = 0;
    protected int str = 0;
    protected int dex = 0;
    protected int wis = 0;
    protected int chr = 0;
    protected int ini = 0;

    public Entity(int pX, int pY, int pLvl) {
        RoomX = pX;
        RoomY = pY;
        lvl = pLvl;
    }

    public void myTurn() {

    }
}
