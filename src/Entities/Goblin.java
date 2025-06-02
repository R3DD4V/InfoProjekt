package Entities;

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
    }

    @Override
    public void myTurn() {
        System.out.println("goblin Turn");
        this.hp-=1;
    }
}
