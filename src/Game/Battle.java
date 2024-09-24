package Game;

import Droid.Droid;
import Locality.Locality;
import Strategy.Strategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Battle {
    static Scanner console = new Scanner(System.in);

    File temp = new File("temp.txt");
    FileWriter writer;
    private Droid[][] command;
    private Strategy[] strat;
    private int number_action;

    Battle(Droid[][] command, Locality loc, Strategy[] strat) {
        number_action = 0;
        this.command = command;
        this.strat = strat;
        loc.setModifity(this.command);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < this.command[i].length; j++) {
                this.command[i][j].start();
            }
        }
        try {
            writer = new FileWriter("temp.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void battle() {
        int cc = 0;
        int ac = 1;
        while (true) {
            if (this.acommandLive(ac)) {
                for (int cd = 0; cd < command[cc].length; cd++) {
                    if (command[cc][cd].live) {
                        if (command[cc][cd].active) {
                            int target = strat[cc].getTarget(command[cc][cd], command[ac]);
                            command[cc][cd].activeAction(target, command, cc, ac);
                            this.Printer(cc, cd);
                            console.nextLine();
                            this.RePrinter();
                        } else {
                            command[cc][cd].nonActiveAction();
                        }
                    }
                }
                int c = cc;
                cc = ac;
                ac = c;
                if (cc == 0) {
                    number_action++;
                }
            } else {
                this.finish(cc);
                return;
            }
        }
    }

    boolean acommandLive(int ac) {
        for (int i = 0; i < command[ac].length; i++) {
            if (command[ac][i].live) {
                return true;
            }
        }
        return false;
    }

    void Printer(int cc, int cd) {
        int maxLenL = 0;
        int maxLenR = 0;
        char[] mark = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'r'};
        String[] leftInfo = new String[37];
        char[][] Map = new char[37][71];
        String[] rightInfo = new String[37];
        int cursor1 = 0;
        leftInfo[cursor1] = "Команда 1:";
        rightInfo[cursor1] = "Команда 2:";
        if (command[cc].length == 1) {
            for (cursor1 = 1; cursor1 < 16; cursor1++) {
                leftInfo[cursor1] = "";
                rightInfo[cursor1] = "";
            }
            leftInfo[cursor1] = String.join("", String.valueOf(mark[0]), " - ", command[0][0].getName(), ":");
            leftInfo[cursor1 + 1] = String.join("", "Здоров'я - ", String.valueOf(command[0][0].health), ", Броня - ", String.valueOf(command[0][0].armor));
            leftInfo[cursor1 + 2] = String.join("", "Урон - ", String.valueOf(command[0][0].damage), ", Пробиття - ", String.valueOf(command[0][0].antiArmor),
                    ", Дальність - ", String.valueOf(command[0][0].hitRange));
            leftInfo[cursor1 + 3] = String.join("", "Енергія - ", String.valueOf(command[0][0].energy), ", Дальність ходу - ", String.valueOf(command[0][0].distMotion));
            if (command[0][0].ultra == null) {
                leftInfo[cursor1 + 4] = String.join("", "Cпецможливість - відсутня");
            } else {
                leftInfo[cursor1 + 4] = String.join("", "Cпецможливість - ", command[0][0].ultra.getName());
            }
            leftInfo[cursor1 + 5] = String.join("", "Живий - ", boolTranslate(command[0][0].live),", Видимий - ", boolTranslate(command[0][0].vision));
            rightInfo[cursor1] = String.join("", String.valueOf(mark[5])," - ", command[1][0].getName(), ":");
            rightInfo[cursor1 + 1] = String.join("", "Здоров'я - ", String.valueOf(command[1][0].health), ", Броня - ", String.valueOf(command[1][0].armor));
            rightInfo[cursor1 + 2] = String.join("", "Урон - ", String.valueOf(command[1][0].damage), ", Пробиття - ", String.valueOf(command[1][0].antiArmor),
                    ", Дальність - ", String.valueOf(command[1][0].hitRange));
            rightInfo[cursor1 + 3] = String.join("", "Енергія - ", String.valueOf(command[1][0].energy), ", Дальність ходу - ", String.valueOf(command[1][0].distMotion));
            if (command[1][0].ultra == null) {
                rightInfo[cursor1 + 4] = String.join("", "Cпецможливість - відсутня");
            } else {
                rightInfo[cursor1 + 4] = String.join("", "Cпецможливість - ", command[1][0].ultra.getName());
            }
            rightInfo[cursor1 + 5] = String.join("", "Живий - ", boolTranslate(command[1][0].live),", Видимий - ", boolTranslate(command[1][0].vision));
            cursor1 += 6;
            for (;cursor1 < 37; cursor1++) {
                leftInfo[cursor1] = "";
                rightInfo[cursor1] = "";
            }
        } else {
            int i = 0;
            for (cursor1 = 1; cursor1 < 36; cursor1 += 7) {
                leftInfo[cursor1] = "";
                rightInfo[cursor1] = "";
                leftInfo[cursor1 + 1] = String.join("", String.valueOf(mark[i]), " - ", command[0][i].getName(), ":");
                leftInfo[cursor1 + 2] = String.join("", "Здоров'я - ", String.valueOf(command[0][i].health), ", Броня - ", String.valueOf(command[0][i].armor));
                leftInfo[cursor1 + 3] = String.join("", "Урон - ", String.valueOf(command[0][i].damage), ", Пробиття - ", String.valueOf(command[0][i].antiArmor),
                        ", Дальність - ", String.valueOf(command[0][i].hitRange));
                leftInfo[cursor1 + 4] = String.join("", "Енергія - ", String.valueOf(command[0][i].energy), ", Дальність ходу - ", String.valueOf(command[0][i].distMotion));
                if (command[0][i].ultra == null) {
                    leftInfo[cursor1 + 5] = String.join("", "Cпецможливість - відсутня");
                } else {
                    leftInfo[cursor1 + 5] = String.join("", "Cпецможливість - ", command[0][i].ultra.getName());
                }
                leftInfo[cursor1 + 6] = String.join("", "Живий - ", boolTranslate(command[0][i].live),", Видимий - ", boolTranslate(command[0][i].vision));
                rightInfo[cursor1 + 1] = String.join("", String.valueOf(mark[i + 5]), " - ", command[1][i].getName(), ":");
                rightInfo[cursor1 + 2] = String.join("", "Здоров'я - ", String.valueOf(command[1][i].health), ", Броня - ", String.valueOf(command[1][i].armor));
                rightInfo[cursor1 + 3] = String.join("", "Урон - ", String.valueOf(command[1][i].damage), ", Пробиття - ", String.valueOf(command[1][i].antiArmor),
                        ", Дальність - ", String.valueOf(command[1][i].hitRange));
                rightInfo[cursor1 + 4] = String.join("", "Енергія - ", String.valueOf(command[1][i].energy), ", Дальність ходу - ", String.valueOf(command[1][i].distMotion));
                if (command[1][i].ultra == null) {
                    rightInfo[cursor1 + 5] = String.join("", "Cпецможливість - відсутня");
                } else {
                    rightInfo[cursor1 + 5] = String.join("", "Cпецможливість - ", command[1][i].ultra.getName());
                }
                rightInfo[cursor1 + 6] = String.join("", "Живий - ", boolTranslate(command[1][i].live),", Видимий - ", boolTranslate(command[1][i].vision));
                i++;
            }
            leftInfo[36] = "";
            rightInfo[36] = "";
        }
        for (int i = 0; i < 71; i++) {
            Map[0][i] = '-';
            Map[36][i] = '-';
        }
        for (int i = 1; i < 36; i++) {
            Map[i][0] = '|';
            Map[i][70] = '|';
        }
        for (int i = 1; i < 36; i++) {
            for (int j = 1; j < 70; j++) {
                Map[i][j] = ' ';
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < command[i].length; j++) {
                if (command[i][j].live) {
                    Map[command[i][j].pos.getY()][command[i][j].pos.getX() * 2 - 1] = mark[5 * i + j];
                }
            }
        }
        for (int i = 0; i < 37; i++) {
            if (leftInfo[i].length() > maxLenL) {
                maxLenL = leftInfo[i].length();
            }
            if (rightInfo[i].length() > maxLenR) {
                maxLenR = rightInfo[i].length();
            }
        }
        String str;
        str = String.join("", "Свій хід зробив дроїд - ", command[cc][cd].getName(), " команди №", String.valueOf(cc + 1), "\n");

        print(str);
        int cp = 0;
        for (int i = 0; i < 37; i++) {
            print(leftInfo[i]);
            cp = maxLenL - leftInfo[i].length();
            for (int j = 0; j < 4 + cp; j++) {
                print(" ");
            }
            print(String.valueOf(Map[i]));
            cp = maxLenR - rightInfo[i].length();
            for (int j = 0; j < 4 + cp; j ++) {
                print(" ");
            }
            print(rightInfo[i]);
            print("\n");
        }
    }

    void RePrinter() {
        System.out.print("\n\n\n");
     }

    void finish (int cc){
        System.out.printf("\nПеремогла команда %d\n", cc + 1);
        while (true) {
            System.out.print("""
                   Зберегти гру?
                   1 - Так
                   2 - Ні
                   -> """);
            int f = console.nextInt();
            if (f == 1) {
                saveFile();
                return;
            } else if (f == 2) {
                System.out.print("\n");
                return;
            } else  {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }

    void print(String str) {
        System.out.print(str);
        try {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String boolTranslate (boolean bool) {
        if (bool) {
            return "Так";
        } else {
            return "Ні";
        }
    }

    void saveFile() {
        System.out.print("\nВ який файл зберегти?\n");
        console.nextLine();
        String fileName = console.nextLine();
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        temp.renameTo(new File(fileName));
        System.out.print("\n");
    }
}
