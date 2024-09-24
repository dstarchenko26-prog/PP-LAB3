package Strategy;

import Droid.Droid;

import java.util.Scanner;

public class Strategy {

    public int strat;
    static Scanner console = new Scanner(System.in);

    public Strategy(int numCom) {
        while (true) {
            System.out.printf("\nЗадайте стратегію %d команди:\n", numCom);
            System.out.print("""
                    1 - Пріорітет найближчий
                    2 - Пріорітет з найбільшим максимальним рівнем здоров'я
                    3 - Пріорітет найсильніший
                    4 - Пріорітет з найменшим залишком здоров'я
                    ->""");
            int f = console.nextInt();
            if (f > 0 && f < 5) {
                strat = f;
                return;
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }

    public int getTarget(Droid droid, Droid[] aCommand) {
        int target = 0;
        if (strat == 1) {
            int minDist = 999;
            for (int cd = 0; cd < aCommand.length; cd++) {
                int dist = droid.pos.dist(aCommand[cd].pos);
                if (dist < minDist && aCommand[cd].vision && aCommand[cd].live) {
                    minDist = dist;
                    target = cd;
                }
            }
        } else if (strat == 2) {
            int maxHealth = 0;
            for (int cd = 0; cd < aCommand.length; cd++) {
                int Health = aCommand[cd].maxHealth;
                if (maxHealth < Health && aCommand[cd].vision && aCommand[cd].live) {
                    maxHealth = Health;
                    target = cd;
                }
            }
        } else if (strat == 3) {
            int maxDamage = 0;
            for (int cd = 0; cd < aCommand.length; cd++) {
                int Damage = aCommand[cd].damage;
                if (maxDamage < Damage && aCommand[cd].vision && aCommand[cd].live) {
                    maxDamage = Damage;
                    target = cd;
                }
            }
        } else {
            int minHealth = 999999;
            for (int cd = 0; cd < aCommand.length; cd++) {
                int Health = aCommand[cd].health;
                if (Health < minHealth && aCommand[cd].vision && aCommand[cd].live) {
                    minHealth = Health;
                    target = cd;
                }
            }
        }
        return target;
    }
}
