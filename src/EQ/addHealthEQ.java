package EQ;

import Droid.Droid;

public class addHealthEQ extends EQ{
    public addHealthEQ() {
        super("Закалка");
    }

    public void equipEQ(Droid droid){
        droid.maxHealth = 3 * droid.maxHealth / 2;
        droid.armor = 2 * droid.armor / 3;
        droid.distMotion -= 2;
    }
}