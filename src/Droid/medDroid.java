package Droid;

import Ultra.Healthy;

public class medDroid extends Droid{
    public medDroid () {
        super();
        maxHealth = 200;
        armor = 100;
        damage = -50;
        antiArmor = 0;
        hitRange = 8;
        maxEnergy = 100;
        distMotion = 12;
        countEQ = 2;
        ultra = new Healthy();
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
                ultra.enableMed(this, command[cc]);
            }
        }
        int newTarget = getTarget(command[cc]);
        int distToTarget = pos.dist(command[cc][newTarget].pos);
        if (distToTarget < hitRange) {
            int realDamage = Math.abs(damage);
            energy += realDamage / 2;
            command[cc][newTarget].setHealthy(realDamage);
        } else {
            pos.move(command[cc][newTarget].pos, distMotion, hitRange);
        }
        if (ultra != null) {
            ultra.droidAction();
        }
    }

    int getTarget(Droid[] command) {
        int target = 0;
        int i = 0;
        for (int cd = 0; cd < command.length; cd++) {
            int minHealth = 999999;
            if (command[cd].live && command[cd].health != command[cd].maxHealth && pos.dist(command[cd].pos) <= hitRange && command[cd].health < minHealth) {
                minHealth = command[cd].health;
                target = cd;
                i = 1;
            }
        }
        if (i == 0) {
            for (int cd = 0; cd < command.length; cd++) {
                int minHealth = 999999;
                if (command[cd].live && command[cd].health != command[cd].maxHealth && command[cd].health < minHealth) {
                    minHealth = command[cd].health;
                    target = cd;
                }
            }
        }
        return target;
    }
}