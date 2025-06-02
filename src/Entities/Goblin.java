package Entities;

import java.util.ArrayList;
import java.util.List;

public class Goblin extends Monster{
    public Goblin(int pX, int pY, int pLvl) {
        super(pX, pY, pLvl);
        this.str = 3+lvl;
        this.chr = 0;
        this.hp = 20+2*lvl;
        this.maxHp = this.hp;
        this.dex = 3+lvl;
        this.ini = (int)(2+Math.random()*lvl);
        this.wis = 2;
        this.name = "Goblin";
    }

    @Override
    public void myTurn(List<Entity> order, Entity player) {
        int chanceSum = 10+10+5*(lvl>=10?1:0);
        int rand = (int) (Math.random()*chanceSum);

        if (rand<10) {
            abs+=7+lvl;
            System.out.println("Goblin defend");
        }
        else if (rand<20) {
            int damage = 5+str;
            player.attacked(damage);
            System.out.println("Goblin attack for "+damage);
            System.out.println(player.getHpSt());
        }
        else if (rand<25)  {
            this.hp+=10;
            if (this.hp>this.maxHp) {
                this.hp = this.maxHp;
            }
            System.out.println("Goblin Heal for  10hp");
            System.out.println(hp+"/"+maxHp);
        }
    }
}
