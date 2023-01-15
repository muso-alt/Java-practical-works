import java.util.Scanner;

public class AverageAndMax {
    public AverageAndMax(){
        Scanner sc = new Scanner (System.in);
    
        System.out.println("Enter count int elements: ");
	    int count = sc.nextInt();

        var massive = new int[count];
        var sumOfElements = 0;

        for(int i = 0; i < massive.length; i++){
            
            System.out.println("Enter " + i + " int element: ");
            var element = sc.nextInt();
            sumOfElements += element;
            massive[i] = element;
        }

        //Get average arithmetic of all values
        var averageArithmetic = sumOfElements / massive.length;
        System.out.println("Average is: " + averageArithmetic);
        
        //Get max value
        var max = massive[0];

        for(int i = 1; i < massive.length; i++){
            if(max < massive[i]){
                max = massive[i];
            }
        }

        System.out.println("Max value is: " + max);

        sc.close();
    }
}
