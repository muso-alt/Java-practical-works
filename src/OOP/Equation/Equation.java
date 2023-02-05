package OOP.Equation;
import java.util.Scanner;

public class Equation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a, b, c;
        System.out.println("Программа решает квадратное уравнение вида:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Введите a, b и c:");
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
       
        var root = new RootGet(a, b, c);
        root.Calculate();

        in.close();
    }
}
