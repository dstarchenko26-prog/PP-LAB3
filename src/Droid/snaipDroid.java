package Droid;

import Ultra.Damage;

public class snaipDroid extends Droid {
    public snaipDroid () {
        super();
        maxHealth = 200;
        armor = 100;
        damage = 50;
        antiArmor = 200;
        hitRange = 20;
        maxEnergy = 100;
        distMotion = 6;
        countEQ = 2;
        ultra = new Damage();
        this.setEQ();
    }

    public void activeAction(int target, Droid[][] command, int cc, int ac) {
        if (energy + 10 < maxEnergy) {
            energy+= 10;
        } else {
            energy = maxEnergy;
        }
        if (ultra != null) {
            if (energy >= ultra.price) {
                ultra.enable(this);
            }
        }
        int distToTarget = pos.dist(command[ac][target].pos);
        if (distToTarget <= hitRange) {
            int realDamage = DamageCalc(command[ac][target]);
            energy += realDamage / 2;
            command[ac][target].setAttack(realDamage);
        } else {
            pos.move(command[ac][target].pos, distMotion, hitRange);
        }
        if (ultra != null) {
            ultra.droidAction();
        }
        timer = 1;
        active = false;
    }
}
