package Entities;

import java.util.ArrayList;
import java.util.List;

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
    protected boolean enemy;
    protected int abs = 0;

    public Entity(int pX, int pY, int pLvl) {
        RoomX = pX;
        RoomY = pY;
        lvl = pLvl;
    }

    public void myTurn(List<Entity> order, Entity player) {

    }

    public void attacked(int damage) {
        if (damage>abs)  {
            hp-=(damage-abs);
            abs = 0;
        }
        else {
            abs-=damage;
        }
    }

    public String getHpSt()  {
        if (hp >= 0) {
            return "["+hp+"/"+maxHp+"]";
        }
        else {
            return "[0/"+maxHp+"]";
        }
    }
}
