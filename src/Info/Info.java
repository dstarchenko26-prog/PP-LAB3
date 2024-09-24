package Info;

import java.util.Scanner;

public class Info {

    static Scanner console = new Scanner(System.in);

    public Info () {
        while (true) {
            System.out.print("""

                    Меню:
                    1 - Загальна інформація
                    2 - Типи дроїдів
                    3 - Обладнання
                    4 - Локації
                    5 - Стратегії
                    6 - Механіки
                    0 - Назад
                    -> """);
            int f = console.nextInt();
            if (f == 1) {
                System.out.print("""

                        Гра дає можливість створювати власних дроїдів та проводити бої між ними.
                        Можливі бої 1 на 1 та командні 5 на 5.
                        Бої проводяться комп'ютером, але користувач може задавати стратегію поведінки.
                        """);
            } else if (f == 2) {
                infDroid inf = new infDroid();
            } else if (f == 3) {
                infEQ inf = new infEQ();
            } else if (f == 4) {
                infLoc inf = new infLoc();
            } else if (f == 5) {
                System.out.print("""
                        
                        Існує 4 передбачених грою стратегії:
                        1 - Пріорітет найближчий
                        2 - Пріорітет з найбільшим максимальним рівнем здоров'я
                        3 - Пріорітет найсильніший
                        4 - Пріорітет з найменшим залишком здоров'я
                        """);
            } else if (f == 6) {
                System.out.print("""
                        
                        Наявна механіка бронепробиття:
                        броня > пробиття - 50% урону
                        броня = пробиття - 100% урону
                        броня < пробиття - 150% урону
                        """);
            } else if (f == 0) {
                System.out.print("\n");
                return;
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }
}
