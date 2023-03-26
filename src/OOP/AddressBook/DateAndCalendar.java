package OOP.AddressBook;

import java.util.*;

public class DateAndCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ввод года, месяца и дня
        System.out.print("Введите год: ");
        int year = input.nextInt();

        System.out.print("Введите месяц (1-12): ");
        int month = input.nextInt() - 1; // Так как месяцы в Java начинаются с 0, вычитаем 1

        System.out.print("Введите число: ");
        int day = input.nextInt();

        // Ввод часов и минут
        System.out.print("Введите часы (0-23): ");
        int hour = input.nextInt();

        System.out.print("Введите минуты (0-59): ");
        int minute = input.nextInt();

        // Создание объекта Date
        Date date = new Date(year - 1900, month, day, hour, minute);

        // Создание объекта Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Вывод результатов
        System.out.println("Объект Date: " + date);
        System.out.println("Объект Calendar: " + calendar.getTime());
    }
}
