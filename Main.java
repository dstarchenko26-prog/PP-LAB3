import Info.Info;
import Game.Game;
import Droid.Droid;

import java.util.Scanner;

public class Main {

    public static Scanner console = new Scanner(System.in);
    static Game game = new Game();
    private static Droid[] array = new Droid[0];

    public static void main(String[] args) {
        while (true) {
            System.out.print("""
                    Меню:
                    1 - Створити нового дроїда
                    2 - Показати список дроїдів
                    3 - Запустити гру
                    4 - Відтворити записану гру
                    5 - Інфо
                    0 - Вийти
                    -> """);
            int f = console.nextInt();
            if (f == 1) {
                array = game.addDroid(array);
            } else if (f == 2) {
                game.printListDroid(array);
            } else if (f == 3) {
                game.setListDroid(array);
                game.start();
            } else if (f == 4) {
                game.rePrintGame();
            } else if (f == 5) {
                Info inf = new Info();
            } else if (f == 0) {
                break;
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }
}