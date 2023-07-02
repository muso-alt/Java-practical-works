import java.util.Scanner;

class TariffPlan {
    protected double callCost;

    public TariffPlan(double callCost) {
        this.callCost = callCost;
    }

    public void printInfo() {
        System.out.println("Тип сотовой связи: Общий");
        System.out.println("Общая продолжительность разговора: Не определено");
    }
}

class MTSPhone extends TariffPlan {
    private String type;
    private double accountBalance;
    private boolean specialConditions;

    public MTSPhone(double callCost, String type, double accountBalance, boolean specialConditions) {
        super(callCost);
        this.type = type;
        this.accountBalance = accountBalance;
        this.specialConditions = specialConditions;
    }

    @Override
    public void printInfo() {
        System.out.println("Тип сотовой связи: " + type);
        double totalDuration = accountBalance / callCost;
        System.out.println("Общая продолжительность разговора: " + totalDuration + " минут");
    }
}

class MegafonPhone extends TariffPlan {
    private String type;
    private double accountBalance;
    private int freeMinutes;

    public MegafonPhone(double callCost, String type, double accountBalance, int freeMinutes) {
        super(callCost);
        this.type = type;
        this.accountBalance = accountBalance;
        this.freeMinutes = freeMinutes;
    }

    @Override
    public void printInfo() {
        System.out.println("Тип сотовой связи: " + type);
        double totalDuration = (accountBalance - (freeMinutes * callCost)) / callCost;
        System.out.println("Общая продолжительность разговора: " + totalDuration + " минут");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TariffPlan[] objects = new TariffPlan[3]; // Создаем массив для хранения ссылок на объекты

        // Вводим информацию от пользователя и создаем объекты
        System.out.println("Введите информацию о тарифном плане сотовой связи:");
        System.out.print("Стоимость минуты разговора: ");
        double callCost = scanner.nextDouble();
        objects[0] = new TariffPlan(callCost);

        System.out.println("\nВведите информацию о телефоне МТС:");
        System.out.print("Тип сотовой связи: ");
        String typeMTS = scanner.next();
        System.out.print("Сумма на счете: ");
        double balanceMTS = scanner.nextDouble();
        System.out.print("Особые условия (true/false): ");
        boolean specialConditions = scanner.nextBoolean();
        objects[1] = new MTSPhone(callCost, typeMTS, balanceMTS, specialConditions);

        System.out.println("\nВведите информацию о телефоне Мегафон:");
        System.out.print("Тип сотовой связи: ");
        String typeMegafon = scanner.next();
        System.out.print("Сумма на счете: ");
        double balanceMegafon = scanner.nextDouble();
        System.out.print("Количество бесплатных минут: ");
        int freeMinutes = scanner.nextInt();
        objects[2] = new MegafonPhone(callCost, typeMegafon, balanceMegafon, freeMinutes);

        // Выводим результирующую информацию с использованием цикла
        System.out.println("\nРезультирующая информация:");
        for (TariffPlan object : objects) {
            object.printInfo();
            System.out.println();
        }
    }
}