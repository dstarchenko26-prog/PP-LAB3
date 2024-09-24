package Ultra;

import Droid.Droid;

public class Vision extends Ultra{
    public Vision() {
        super("Невидимість");
        price = 100;
        timer = 0;
        active = false;
    }

    public void enable(Droid droid) {
        super.enable(droid);
        droid.vision = false;
    }

    void disable() {
        super.disable();
        droid.vision = true;
    }
}
