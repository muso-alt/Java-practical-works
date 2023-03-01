package Interfaces.RNG;

import java.util.Random;

public class RNGImpl implements IRNG {

    private int _randomizedValue = 0;

    @Override
    public void generate() {
        var random = new Random();
        _randomizedValue = random.nextInt(9);
        System.out.println("Your random value between 0-9: " + _randomizedValue);
    }

    @Override
    public void anyLuck() {
        if(_randomizedValue == 7){
            System.out.println("Lucky!");
        }else{
            System.out.println("No Luck...");
        }
    }
    
}
