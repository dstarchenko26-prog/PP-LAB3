package Droid;

public class classicDroid extends Droid{
    public classicDroid () {
        super();
        maxHealth = 200;
        armor = 100;
        damage = 50;
        antiArmor = 100;
        hitRange = 8;
        maxEnergy = 0;
        distMotion = 12;
        countEQ = 2;
        ultra = null;
        this.setEQ();
    }
}
