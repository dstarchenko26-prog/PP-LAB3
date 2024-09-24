package EQ;

import Droid.Droid;

public class addAntiArmorEQ extends EQ {
    public addAntiArmorEQ() {
        super("Подвійний пороховий заряд");
    }

    public void equipEQ(Droid droid) {
        droid.antiArmor = 3 * droid.antiArmor / 2;
        droid.damage = 2 * droid.damage / 3;
        droid.distMotion -= 2;
    }
}