import java.util.Random;
import java.util.Scanner;

public class Odds {
    public Odds(){
        
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter max value of random elements: ");
	    int k = sc.nextInt();

        var array = new int[100];
        var random = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(0, k);
            System.out.print(array[i] + ", ");
        }

        System.out.println("");
        System.out.println("Simple numbers count: " + GetSimpleNumbersCount(array));
        System.out.println("Numbers that multiplie to 3 count: " + GetOfMultipliesCount(array, 3));

        sc.close();
    }

    private int GetSimpleNumbersCount(int[] array){
        var simpleNumbersCount = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                simpleNumbersCount++;
            }
        }

        return simpleNumbersCount;
    }

    private int GetOfMultipliesCount(int[] array, int numberForMultiplie){
        var count = 0;
        for (int i = 1; i < array.length; i++)
	    {
            if (array[i] % 3 == 0){
                    count++;
                }
	    }

        return count;
    }
}
