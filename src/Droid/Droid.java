package Droid;

import EQ.*;
import Ultra.*;
import Pos.Pos;

import java.util.Scanner;

public class Droid {
    static Scanner console = new Scanner(System.in);

    private final String name;
    public int maxHealth;
    public int health;
    public int armor;
    public int damage;
    public int antiArmor;
    public int hitRange;
    public int maxEnergy;
    public int energy;
    public int distMotion;
    public int timer;
    int countEQ;
    public EQ[] setupEQ;
    public Ultra ultra;
    public Pos pos;

    public boolean live;
    public boolean vision;
    public boolean active;

    Droid() {
        System.out.print("Дайте ім'я дроїду:\n");
        String str = console.nextLine();
        if (str.equals("")) {
            this.name = console.nextLine();
        } else {
            this.name = str;
        }
        System.out.print('\n');
    }

    Droid(Droid example) {
        name = example.name;
        maxHealth = example.maxHealth;
        armor = example.armor;
        damage = example.damage;
        antiArmor = example.antiArmor;
        hitRange = example.hitRange;
        maxEnergy = example.maxEnergy;
        distMotion = example.distMotion;
        countEQ = example.countEQ;
        setupEQ = example.setupEQ;
        ultra = example.ultra;
    }

    public String getName () {
        return name;
    }

    void setEQ() {
        setupEQ = new EQ[0];
        while (true) {
            if (countEQ - setupEQ.length > 0) {
                System.out.printf("""
                        Ви можете обладнати дроїда ще %d од. обладнання:
                        1 - Закалка
                        2 - Бронепластини
                        3 - Розривні патрони
                        4 - Подвійний пороховий заряд
                        5 - Якісні аккумулятори
                        0 - Завершити
                        -> """, countEQ - setupEQ.length);
                int f = console.nextInt();
                System.out.print('\n');
                EQ newEQ = null;
                if (f == 0) {
                    return;
                } else if (f == 1) {
                    newEQ = new addHealthEQ();
                } else if (f == 2) {
                    newEQ = new addArmorEQ();
                } else if (f == 3) {
                    newEQ = new addDamageEQ();
                } else if (f == 4) {
                    newEQ = new addAntiArmorEQ();
                } else if (f == 5) {
                    newEQ = new addEnergyEQ();
                } else {
                    System.out.print("Помилка введення!\n\n");
                    continue;
                }
                newEQ.equipEQ(this);
                EQ[] newSetupEQ = new EQ[setupEQ.length + 1];
                for (int i = 0; i < setupEQ.length; i++) {
                    newSetupEQ[i] = setupEQ[i];
                }
                setupEQ = newSetupEQ;
                setupEQ[setupEQ.length - 1] = newEQ;
            } else {
                return;
            }
        }
    }

    public String toString() {
        String line = String.join("", this.getName(), ":\n",
                "Здоров'я - ", String.valueOf(maxHealth), ", Броня - ",
                String.valueOf(armor), "\nУрон - ", String.valueOf(damage),
                ", Пробиття - ", String.valueOf(antiArmor), ", Дальність - ",
                String.valueOf(hitRange), "\nЛіміт енергії - ",
                String.valueOf(maxEnergy), ", Дальність ходу - ",
                String.valueOf(distMotion), "\nОбладнання:");
        if (setupEQ.length == 0) {
            line = String.join(" ", line, "Відсутнє");
        } else {
            line = String.join(" ", line, setupEQ[0].getName());
            for (int i = 1; i < setupEQ.length; i++) {
                line = String.join(", ", line, setupEQ[i].getName());
            }
        }
        line = String.join("", line, "\nCпецможливість - ");
        if (ultra == null) {
            line = String.join("", line, "відсутня");
        } else {
            line = String.join("", line, ultra.getName());
        }
        return line;
    }

    public void start() {
        health = maxHealth;
        energy = 0;
        timer = 0;
        live = true;
        vision = true;
        active = true;
        if (ultra != null) {
            ultra.start();
        }
    }

    public void nonActiveAction() {
        if (energy + 10 < maxEnergy) {
            energy+= 10;
        } else {
            energy = maxEnergy;
        }
        timer--;
        if (timer == 0) {
            active = true;
        }
        if (ultra != null) {
            ultra.droidAction();
        }
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
    }

    int DamageCalc(Droid target) {
        int realDamage = damage;
        if (ultra != null) {
            if (ultra.getName().equals("Ультра-урон") && ultra.active) {
                realDamage *= 3;
            }
        }
        int realArmor = target.armor;
        if (target.ultra != null) {
            if (target.ultra.getName().equals("Щит") && target.ultra.active) {
                realArmor *= 2;
            }
        }
        if (realArmor > antiArmor) {
            realDamage /= 2;
        } else if (realArmor < antiArmor) {
            realDamage += realDamage / 2;
        }
        return realDamage;
    }

    public void setAttack(int rDamage) {
        health -= rDamage;
        if (health <= 0) {
            live = false;
        }
    }

    public void setHealthy(int rDamage) {
        if (health + rDamage >= maxHealth) {
            health = maxHealth;
        } else {
            health += rDamage;
        }
    }

    public Droid copy() {
        return new Droid(this);
    }
}
