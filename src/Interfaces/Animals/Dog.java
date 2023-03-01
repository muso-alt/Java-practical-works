package Interfaces;

public class Dog implements IVoice{

    @Override
    public void Voice() {
        System.out.println("Woof!");
    }
}