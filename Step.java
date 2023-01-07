import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Step {
        Scanner scanner = new Scanner(System.in);

    HashMap <String, ArrayList <Integer>> monthDays;
    ArrayList <Integer> daysMonth;
    int[] day = new int[30];

    Step(String[] months) {
        monthDays = new HashMap<>();
        for (String month : months) {
            monthDays.put(month, daysMonth);
        }
        daysMonth = new ArrayList<>();
        for (int i : day) {
            daysMonth.add(i);
        }
    }

    void Steps(String month, int days, int step) {
        if (step >= 0) {
            daysMonth.set((days - 1), step);
            monthDays.put(month, daysMonth);
            System.out.println("Шаги сохранены.");
        } else {
            System.out.println("Шаги отрицательные не могут быть");
        }
    }

    void goSteps(String month) {
        ArrayList<Integer> stepsDay = monthDays.get(month);
        for (int i = 0 ; i < stepsDay.size(); i++) {
            System.out.println((i + 1) + " день: " + stepsDay.get(i));
        }
    }

    void sumStep(String month) {
        ArrayList<Integer> stepsDay = monthDays.get(month);
        int sumStep = 0;
        for (Integer sum : stepsDay) {
            sumStep += sum;
        }
        System.out.println("За месяц вы прошли "+ sumStep + " шагов." );
    }

    void maxStep(String month) {
        ArrayList<Integer> stepsDay = monthDays.get(month);
        int maxStep = 0;
        for (Integer max : stepsDay) {
            if (max > maxStep) {
                maxStep = max;
            }
        }
        System.out.println("Максимальное количество шагов за " + month + " - "+ maxStep);
    }

    void minStep(String month) {
        ArrayList<Integer> stepsDay = monthDays.get(month);
        int minStep = 0;
        for (Integer min : stepsDay) {
            if (min < minStep) {
                minStep = min;
            }
        }
        System.out.println("Минимальное количество шагов за " + month + " - "+ minStep);
    }

}

