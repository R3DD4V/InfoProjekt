package Entities;

public class Entity {
    protected int RoomX;
    protected int RoomY;

    protected String name;
    protected int lvl;
    protected int hp;
    protected int maxHp;
    protected int str;
    protected int dex;
    protected int wis;
    protected int chr;

    public Entity(int pX, int pY, int pLvl) {
        RoomX = pX;
        RoomY = pY;
        lvl = pLvl;
    }

    public void myTurn() {

    }
}
