public class Converter {

    // Метод считает дистанцию
    double Distanse(int sumAllSteps){
        double oneStep = 0.75;
        double distanse = (sumAllSteps * oneStep) / 1000;
        System.out.println("За месяц пройдено " + distanse + " км.");
        return distanse;

    }

    // Метод считает калории
    double Callories(int sumAllSteps){
        double oneStepCal = 50;
        double AllCallories = (sumAllSteps * oneStepCal) / 1000;
        System.out.println("За месяц потрачено " + AllCallories + " ккал.");
        return AllCallories;
    }
}
