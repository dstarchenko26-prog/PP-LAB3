package EQ;

import Droid.Droid;

public class addEnergyEQ extends EQ{
    public addEnergyEQ() {
        super("Якісні аккумулятори");
    }

    public void equipEQ(Droid droid){
        droid.maxEnergy = 2 * droid.maxEnergy;
        droid.distMotion -= 2;
    }
}