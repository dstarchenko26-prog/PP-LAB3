package Ultra;

import Droid.Droid;

public class Healthy extends Ultra{
    public Healthy() {
        super("Cфера відновлення");
        price = 100;
        timer = 0;
        active = false;
    }

    public void enableMed(Droid droid, Droid[] command) {
        droid.energy -= price;
        for (int cd = 0; cd < command.length; cd++){
            if (droid.pos.dist(command[cd].pos) <= 4 && command[cd].live) {
                command[cd].health = command[cd].maxHealth;
            }
        }
    }
}
