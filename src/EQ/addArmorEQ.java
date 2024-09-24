package EQ;

import Droid.Droid;

public class addArmorEQ extends EQ{
    public addArmorEQ() {
        super("Бронепластини");
    }

    public void equipEQ(Droid droid){
        droid.maxHealth = 2 * droid.maxHealth / 3;
        droid.armor = 3 * droid.armor / 2;
        droid.distMotion -= 2;
    }
}