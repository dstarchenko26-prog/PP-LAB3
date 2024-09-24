package Droid;

import Ultra.Vision;

public class scoutDroid extends Droid{
    public scoutDroid () {
        super();
        maxHealth = 200;
        armor = 100;
        damage = 100;
        antiArmor = 100;
        hitRange = 3;
        maxEnergy = 100;
        distMotion = 18;
        countEQ = 1;
        ultra = new Vision();
        this.setEQ();
    }
}
