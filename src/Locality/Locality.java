package Locality;

import java.util.Scanner;
import Droid.Droid;
import Pos.Pos;

public class Locality {
    int size = 35;
    static Scanner console = new Scanner(System.in);
    int i;

    public Locality () {
        while (true) {
            System.out.print("\nОберіть локацію:\n1 - Рівнина\n" +
                    "2 - Гори\n3 - Місто\n-> ");
            int f = console.nextInt();
            if (f > 0 && f < 4) {
                i = f;
                return;
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }

    public void setModifity(Droid[][] command) {
        if (i == 2) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < command[i].length; j++) {
                    command[i][j].distMotion -= 2;
                }
            }
        }
        if (i == 3) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < command[i].length; j++) {
                    command[i][j].hitRange -= 2;
                }
            }
        }
        if (command[0].length == 1) {
            command[0][0].pos = new Pos(2,2);
            command[1][0].pos = new Pos(size - 1, size - 1);
        } else {
            command[0][0].pos = new Pos(2, 2);
            command[0][1].pos = new Pos(2, 10);
            command[0][2].pos = new Pos(2, 18);
            command[0][3].pos = new Pos(2, 26);
            command[0][4].pos = new Pos(2, 34);
            command[1][0].pos = new Pos(34, 2);
            command[1][1].pos = new Pos(34, 10);
            command[1][2].pos = new Pos(34, 18);
            command[1][3].pos = new Pos(34, 26);
            command[1][4].pos = new Pos(34, 34);
        }
    }
}