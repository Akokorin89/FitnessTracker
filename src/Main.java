import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker StepTracker = new StepTracker();
        printMenu();
        int command = scanner.nextInt();

        while (true) {           // обаботка разных случаев
            if (command == 1) {
                System.out.println("Введите месяц");
                int month = scanner.nextInt();
                System.out.println("Введите день");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int step = scanner.nextInt();
                StepTracker.addStep(month, day, step);
            } else if (command == 2) {
                System.out.println("За какой месяц вывести статистику?");
                int month = scanner.nextInt();
                StepTracker.writeStatisticsMonth(month);
            } else if (command == 3) {
                System.out.println("Введите цель по количеству шагов");
                int target = scanner.nextInt();
                StepTracker.enterTargetStep(target);
            } else if (command == 4) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Команды не сушествует");
            }

            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            command = scanner.nextInt(); // повторное считывание данных от пользователя
        }
    }

    // Печать меню
    private static void printMenu() {
        System.out.println(" ");
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1.Ввести данные за день ");
        System.out.println("2.Напечатать статистику за месяц ");
        System.out.println("3.Изменить цель по количеству шагов в день");
        System.out.println("4.Выйти из приложения");

    }
}

