package Interfaces.Animals;

public class Dog implements IVoice{

    @Override
    public void Voice() {
        System.out.println("Woof!");
    }
}