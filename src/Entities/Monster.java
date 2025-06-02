package Entities;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Entity{

    public Monster(int pX, int pY, int pLvl) {
        super(pX, pY, pLvl);
        enemy = true;
    }


}
