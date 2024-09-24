package Droid;

import Ultra.Armor;

public class tankDroid extends Droid{
    public tankDroid () {
        super();
        maxHealth = 200;
        armor = 200;
        damage = 50;
        antiArmor = 100;
        hitRange = 6;
        maxEnergy = 100;
        distMotion = 8;
        countEQ = 3;
        ultra = new Armor();
        this.setEQ();
    }
}
