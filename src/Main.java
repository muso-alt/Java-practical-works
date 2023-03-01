import java.util.Scanner;

import Interfaces.Animals.Cat;
import Interfaces.Animals.Cow;
import Interfaces.Animals.Dog;
import Interfaces.Animals.IVoice;
import Interfaces.RNG.IRNG;
import Interfaces.RNG.RNGImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        IVoice voice;

        //1
        System.out.println("Enter 1 to see cat \nEnter 2 to see Dog \nEnter 3 to see Cow");
        
        var reader = new Scanner(System.in);
        var value = reader.nextInt();

        switch(value){
            case 1:
                voice = new Cat();
                break;
            case 2:
                voice = new Dog();
                break;
            case 3:
                voice = new Cow();
                break;
            default:
                voice = new Cat();
                break;
        }

        voice.Voice();
        reader.close();

        //3
        IRNG rng = new RNGImpl();
        rng.generate();
        rng.anyLuck();
    }
}
