package Ultra;

import Droid.Droid;

public class Ultra {
    private final String name;
    public int price;
    public int timer;
    public boolean active;
    Droid droid;

    Ultra(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void droidAction() {
        if (active) {
            timer--;
        }
        if (timer == 0 && active) {
            disable();
        }
    }

    public void enable(Droid droid) {
        droid.energy -= price;
        this.droid = droid;
        timer = 3;
        active = true;
    }

    public void enableMed(Droid droid, Droid[] command) {

    }

    void disable() {
        active = false;
    }

    public void start() {
        timer = 0;
        active = false;
        droid = null;
    }
}
