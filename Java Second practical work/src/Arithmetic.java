import java.util.Scanner;

public class Arithmetic {
    public Arithmetic(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter first int element: ");
	    int firstIntElement = sc.nextInt();
        System.out.println("Enter second int element: ");
	    int secondIntElement = sc.nextInt();

        System.out.println(GetArithmeticResult(firstIntElement, secondIntElement, ArithmeticOperators.Addition));
        System.out.println(GetArithmeticResult(firstIntElement, secondIntElement, ArithmeticOperators.Substraction));
        System.out.println(GetArithmeticResult(firstIntElement, secondIntElement, ArithmeticOperators.Multiplication));
        System.out.println(GetArithmeticResult(firstIntElement, secondIntElement, ArithmeticOperators.Division));
        System.out.println(GetArithmeticResult(firstIntElement, secondIntElement, ArithmeticOperators.Modulo));
        sc.close();
    }

    private String GetArithmeticResult(int firstValue, int secondValue, ArithmeticOperators operator){
        var result = "empty";
        switch(operator){
            case Addition:
                var addition = firstValue + secondValue;
                result = firstValue + " + " + secondValue + " = " + addition;
                break;
            case Division:
                var subtraction = firstValue / secondValue;
                result = firstValue + " / " + secondValue + " = " + subtraction;
                break;
            case Modulo:
                var modulo = firstValue % secondValue;
                result = firstValue + " % " + secondValue + " = " + modulo;
                break;
            case Multiplication:
                var multiplication = firstValue * secondValue;
                result = firstValue + " * " + secondValue + " = " + multiplication;
                break;
            case Substraction:
                var substraction = firstValue - secondValue;
                result = firstValue + " - " + secondValue + " = " + substraction;
                break;
            default:
                break;
        }

        return operator.toString() + ": " + result;
    }

    public enum ArithmeticOperators{
        Addition,
        Substraction,
        Multiplication,
        Division,
        Modulo
    }
}
