import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        int purpose = 0; //кол-во цели шагов в день
        System.out.println("Приветствую вас!");

        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь",
                "Октябрь", "Ноябрь", "Декабрь"};

        Step Step = new Step(months);

        Scanner scanner = new Scanner(System.in);

        while (true) { //основное меню
            printMenu();
            System.out.print("Введите цифру: ");
            int menuConsole = scanner.nextInt();
            System.out.println(" ");

            if (menuConsole == 1) { //Цель
                Command1(purpose, scanner);
            }


            else if (menuConsole == 2){ // Шаги
                Command2(months, scanner, Step);
                }


            else if (menuConsole == 3){ //Статистика
                Command3(months, scanner, Step);
                }

            else if (menuConsole == 0){
                Command0();
                break;
            }
            else {
                System.out.println("Такого варианта нет.");
                System.out.println(" ");

            }
        }

    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - цель по количеству шагов в день");
        System.out.println("2 - ввести кол-во шагов в день");
        System.out.println("3 - показать статистику");
        System.out.println("0 - выход");
    } // Меню

    public static void Command1(int purpose, Scanner scanner) {

        while (true) { // Целевое меню
            System.out.println("Внести или посмотрите целевое кол-во шагов в день");
            System.out.println("1 - Внести");
            System.out.println("2 - Посмотреть");
            System.out.println("0 - Назад");
            System.out.print("Введите цифру: ");
            int purposeConsole = scanner.nextInt();
            System.out.println(" ");
            if (purposeConsole == 1) {
                System.out.print("Введите вашу цель: ");
                int purposeSteps = scanner.nextInt();
                System.out.println(" ");
                purpose = purposeSteps;
            } else if (purposeConsole == 2) {
                System.out.println("Цель кол-во шагов в день: " + purpose);
                System.out.println(" ");
            } else if (purposeConsole == 0) {
                System.out.println(" ");
                break;
            } else {
                System.out.println("Такого варианта нет.");
                System.out.println(" ");
            }

        }

    } // Цель

    public static void Command2(String[] months, Scanner scanner, Step Step) { //
        while (true) {
            for (int i = 0; i < months.length; i++) {
                System.out.println((i + 1) + " - " + months[i]);
            }
            System.out.println(" 0 - Назад");

            System.out.print("Выберите месяц: ");
            int monthInt = scanner.nextInt();  // изменить ввод на цифры
            if (monthInt < 0) {
                System.out.println("Такого месяца нет");
                System.out.println(" ");
            } else if (monthInt == 0) {
                break;
            } else if (monthInt > 12) {
                System.out.println("Такого месяца нет");
                System.out.println(" ");
            } else {
                String month = months[monthInt - 1];

                while (true) {
                    if(month == "Январь" || month == "Март" || month == "Май" || month == "Июль" || month == "Август" ||
                            month == "Октябрь" || month == "Декабрь") { // Месяца по 31 д.
                        System.out.print("0 - Назад. ");
                        System.out.print("За какой день месяца " + month  + " вы хотите ввести шаги? Введите от 1 до 31: ");
                    } else if (month == "Апрель" || month == "Июнь" || month == "Сентябрь" ||
                            month == "Ноябрь" ) { // Месяца по 30 д.
                        System.out.print("0 - Назад. ");
                        System.out.print("За какой день месяца " + month + " вы хотите ввести шаги? Введите от 1 до 30: ");
                    } else { // Месяц - 28 д.
                        System.out.print("0 - Назад. ");
                        System.out.print("За какой день месяца " + month + " вы хотите ввести шаги? Введите от 1 до 28: ");
                    }
                    int days = scanner.nextInt();

                    if (days < 0) {
                        System.out.println("Такого дня нет");
                        System.out.println(" ");
                    } else if (days == 0) {
                        System.out.println(" ");
                        break;
                    } else if (days > 31) {
                        System.out.println("Такого дня нет");
                        System.out.println(" ");
                    } else {
                        System.out.print("0 - Назад. ");
                        System.out.print("Введите количество за шагов за " + days + " день месяца " + month + ": ");

                        int step = scanner.nextInt();


                        Step.Steps(month, days, step);


                        System.out.println(" ");

                    }

                }
            }
        }
    } //Шаги

    public static void Command3(String[] months, Scanner scanner, Step Step) {
        System.out.println("Выберите, за какой месяц вы хотите получить статистику: ");
        for (int month = 0; month < months.length; month++) {
            System.out.println((month + 1) + " - " + months[month]);
        }
        System.out.println("0 - Вернуться назад ");

        while (true) {

            int monthInt = scanner.nextInt();

            if (monthInt < 0) {
                System.out.println("Такого месяца нет");
            } else if (monthInt > 12) {
                System.out.println("Такого месяца нет");
            } else if (monthInt == 0) {
                System.out.println("");
                break;
            } else {
                String month = months[monthInt - 1];

                Step.goSteps(month);
                Step.sumStep(month);
                Step.maxStep(month);
                Step.minStep(month);
                break;
            }
        }
    } // статистика

    public static void Command0(){
        System.out.println("Выход");
        System.out.println(" ");

    } // выход




}
