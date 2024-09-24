package EQ;

import Droid.Droid;

public class addDamageEQ extends EQ{
    public addDamageEQ() {
        super("Розривні патрони");
    }

    public void equipEQ(Droid droid){
        droid.damage = 3 * droid.damage / 2;
        droid.antiArmor = 2 * droid.antiArmor / 3;
        droid.distMotion -= 2;
    }
}