package Info;

import java.util.Scanner;

public class infEQ {

    static Scanner console = new Scanner(System.in);

    infEQ() {
        while (true) {
            System.out.print("""
                    
                    Інформація про спорядження:
                    1 - Закалка
                    2 - Бронепластини
                    3 - Розривні патрони
                    4 - Подвійний пороховий заряд
                    5 - Якісні аккумулятори
                    0 - Повернутись назад
                    -> """);
            int f = console.nextInt();
            if (f == 0) {
                return;
            } else if (f == 1) {
                System.out.print("""
                        
                        Закалка:
                        Збільшує здоров'я в 1,5 рази
                        Зменшує броню в 1,5 рази
                        Зменшує дальність ходу на 2 од.
                        """);
            } else if (f == 2) {
                System.out.print("""
                        
                        Бронепластини:
                        Збільшує броню в 1,5 рази
                        Зменшує здоров'я в 1,5 рази
                        Зменшує дальність ходу на 2 од.
                        """);
            } else if (f == 3) {
                System.out.print("""
                        
                        Розривні патрони:
                        Збільшує урон в 1,5 рази
                        Зменшує пробиття в 1,5 рази
                        Зменшує дальність ходу на 2 од.
                        """);
            } else if (f == 4) {
                System.out.print("""
                        
                        Подвійний пороховий заряд:
                        Збільшує пробиття в 1,5 рази
                        Зменшує урон в 1,5 рази
                        Зменшує дальність ходу на 2 од.
                        """);
            } else if (f == 5) {
                System.out.print("""
                        
                        Якісні аккумулятори:
                        Збільшує ліміт енергії вдвічі
                        Зменшує дальність ходу на 2 од.
                        """);
            } else {
                System.out.print("Помилка введення!\n\n");
            }
        }
    }
}