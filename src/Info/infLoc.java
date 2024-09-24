package Info;

import java.util.Scanner;

public class infLoc {

    static Scanner console = new Scanner(System.in);

    infLoc() {
        while (true) {
            System.out.print("""
                                        
                    Інформація про спорядження:
                    1 - Рівнини
                    2 - Гори
                    3 - Місто
                    0 - Повернутись назад
                    -> """);
            int f = console.nextInt();
            if (f == 0) {
                return;
            } else if (f == 1) {
                System.out.print("""
                        
                        Рівнини:
                        Жодних модифікаторів
                        """);
            } else if (f == 2) {
                System.out.print("""
                        
                        Гори:
                        Дальність ходу -2
                        Неефективні бійці:
                        Танк-дроїд
                        Ефективні бійці:
                        Дроїд-снайпер
                        """);
            } else if (f == 3) {
                System.out.print("""
                        
                        Місто:
                        Дальність стрільби -2
                        Неефективні бійці:
                        Дроїд-снайпер
                        Ефективні бійці:
                        Дроїд-розвідник
                        """);
            }
        }
    }
}