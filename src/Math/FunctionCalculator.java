package Math;

import java.util.Scanner;
import java.lang.Math;

public class FunctionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c, xn, xk, h;

        System.out.print("Введите a: ");
        a = scanner.nextDouble();

        System.out.print("Введите b: ");
        b = scanner.nextDouble();

        System.out.print("Введите c: ");
        c = scanner.nextDouble();

        System.out.print("Введите xn: ");
        xn = scanner.nextDouble();

        System.out.print("Введите xk: ");
        xk = scanner.nextDouble();

        System.out.print("Введите шаг h: ");
        h = scanner.nextDouble();

        double x = xn;
        while (x <= xk) {
            double fx;
            if (x < 3.4) {
                fx = (2 * x * x + a) * Math.exp(2 * x);
            } else if (x < 9) {
                fx = 5 * Math.sin(2 * x) - Math.log(x);
            } else {
                fx = Math.cos(2 * x + Math.sqrt(Math.abs(c * x)));
            }
            System.out.printf("f(%.2f) = %.2f%n", x, fx);
            x += h;
        }
    }
}

