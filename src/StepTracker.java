import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {

    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    int target = 10000;
    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    // Добавление шагов
    void addStep(int month, int day, int step) {

        if ((month > 0 && month < 12) && (day > 0 && day <= 30) && step > 0) {
            if (monthToData.containsKey(month)) {
                MonthData stepsPerDay = monthToData.get(month);
                stepsPerDay.daysOfMonth.add(day, step);
                System.out.println("Данные о шагах добавлены");
            }
        } else {
            System.out.println("Данные не корректны");
        }
    }

    //Вывод статистики за месяц
    Integer AllStepsMonth(int month) {
        Converter converter = new Converter();
        int sumAllSteps = 0;
        int maxStep = 0;
        int count = 0;
        int max = 0;
        if (month > 0 && month < 12) {
            MonthData stepsPerDay = monthToData.get(month);
            for (int i = 1; i <= 30; i++) {
                System.out.println("День  " + i + " : " + stepsPerDay.daysOfMonth.get(i) + " шагов. ");
            }
            for (int i = 1; i <= 30; i++) {
                sumAllSteps += stepsPerDay.daysOfMonth.get(i);
            }
            for (int i = 1; i <= 30; i++) {
                if (maxStep <= stepsPerDay.daysOfMonth.get(i)) {
                    maxStep = stepsPerDay.daysOfMonth.get(i);
                }
            }
            for (int i = 1; i <= 30; i++) {
                if (stepsPerDay.daysOfMonth.get(i) >= target) {
                    count++;
                    if (count > max) {
                        max = count;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println("Общее количество шагов за месяц " + sumAllSteps + " шагов.");
            int averStep = sumAllSteps / 30;
            System.out.println("Среднее количество шагов за месяц " + averStep + " шагов.");
            System.out.println("Максимальное количество шагов в месяц " + maxStep + " шагов.");
            System.out.println("Максимальная серия длилась " + max);
            converter.Distanse(sumAllSteps);
            converter.Callories(sumAllSteps);
        } else {
            System.out.println("Месяц не сушествует");
        }
        return sumAllSteps;
    }

    //Задание цели шагов
    public Integer targetStepUser(int targetStep) {
        if (targetStep > 0) {
            target = targetStep;
            System.out.println("Новая цель " + targetStep + " шагов");
        } else {
            System.out.println("Отрицательная цель невозможна");
        }
        return target;
    }

}   // Наполение месяца данными
    class MonthData {

        ArrayList<Integer> daysOfMonth = new ArrayList<>();

        public MonthData() {
            for (int i = 0; i <= 30; i++) {
                daysOfMonth.add(i, 0);
            }
        }
    }






