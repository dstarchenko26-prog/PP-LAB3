package Game;

import Droid.*;
import Locality.Locality;
import Strategy.Strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    static Scanner console = new Scanner(System.in);
    private Droid[] array;

    public Game() {}

    public Droid[] addDroid(Droid[] array) {
        while (true) {
            Droid newDroid = null;
            System.out.print("""

                    Оберіть тип дроїда:
                    1 - Класичний
                    2 - Танк-дроїд
                    3 - Дроїд-розвідник
                    4 - Дроїд-снайпер
                    5 - Дроїд-медик
                    0 - Повернутись назад
                    -> """);
            int f = console.nextInt();
            System.out.print("\n");
            if (f == 1) {
                newDroid = new classicDroid();
            } else if (f == 2) {
                newDroid = new tankDroid();
            } else if (f == 3) {
                newDroid = new scoutDroid();
            } else if (f == 4) {
                newDroid = new snaipDroid();
            } else if (f == 5) {
                newDroid = new medDroid();
            } else if (f == 0) {
                return array;
            } else {
                System.out.print("Помилка введення!\n\n");
                continue;
            }
            int len = array.length;
            Droid[] newArray = new Droid[len + 1];
            for (int i = 0; i < len; i++) {
                newArray[i] = array[i];
            }
            newArray[len] = newDroid;
            return newArray;
        }
    }

    public void printListDroid(Droid[] array) {
        int len = array.length;
        if (len == 0) {
            System.out.print("\nНемає створених дроїдів\n\n");
        } else {
            System.out.print("\nСписок створених дроїдів:\n");
            for (int i = 0; i < len; i++) {
                System.out.print('\n');
                System.out.print(array[i].toString());
                System.out.print('\n');
            }
            System.out.print('\n');
        }
    }

    public void setListDroid(Droid[] array) {
        this.array = array.clone();
    }

    public void start() {
        Droid[][] command = new Droid[0][0];
        while (true) {
            System.out.print("\nМеню:\n1 - 1vs1\n2 - 5vs5\n0 - Повернутись\n->");
            int f = console.nextInt();
            if (f == 1) {
                command = this.createCommand(1);
                break;
            } else if (f == 2) {
                command = this.createCommand(5);
                break;
            } else if (f == 0) {
                return;
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
        Locality loc = this.setLocality();
        Strategy[] st = this.setStrategy();
        Battle bat = new Battle(command, loc, st);
        bat.battle();
        return;
    }

    Droid[][] createCommand(int count) {
        Droid[][] command = new Droid[2][count];
        for (int i = 0; i < 2; i++) {
            int[] out = new int[0];
            for (int j = 0; j < count; j++) {
                System.out.printf("\nCписок дроїдів на вибір в %d команду:\n",i + 1);
                this.listDroid(out);
                System.out.print("->");
                int f = this.correctInt(out, array.length);
                command[i][j] = array[f].copy();
                int[] newOut = new int[j + 1];
                for (int k = 0; k < j; k++) {
                    newOut[k] = out[k];
                }
                out = newOut;
                out[j] = f;
            }
        }
        return command;
    }

    void listDroid(int[] out) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int error = 0;
            for (int j = 0; j < out.length; j++) {
                if (i == out[j]) {
                    error = 1;
                    break;
                }
            }
            if (error == 1) {
                continue;
            }
            System.out.printf("%d - %s\n", i + 1, array[i].getName());
        }
    }

    int correctInt(int[] out, int max) {
        while (true) {
            int f = console.nextInt() - 1;
            if (f >= 0 && f < max) {
                int error = 0;
                for (int i = 0; i < out.length; i++) {
                    if (f == out[i]) {
                        error = 1;
                        break;
                    }
                }
                if (error == 0) {
                    return f;
                } else {
                    System.out.print("Помилка введення!\n\n");
                }
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }

    Locality setLocality(){
        return new Locality();
    }

    Strategy[] setStrategy() {
        Strategy[] st = new Strategy[2];
        st[0] = new Strategy(1);
        st[1] = new Strategy(2);
        return st;
    }

    public void rePrintGame() {
        while (true) {
            System.out.print("З якого файлу прочитати?\n");
            console.nextLine();
            String fileName = console.nextLine();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                while (true) {
                    String str = reader.readLine();
                    if (str != null) {
                        System.out.println(str);
                        for (int i = 0; i < 37; i++) {
                            System.out.println(reader.readLine());
                        }
                        console.nextLine();
                    } else {
                        break;
                    }
                }
                reader.close();
                return;
            } catch (IOException e) {
                System.out.print("Файл не існує\nПовторіть спробу\n");
            }
        }
    }
}