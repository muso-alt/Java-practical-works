package Interfaces;

public class Cat implements IVoice{

    @Override
    public void Voice() {
        System.out.println("Meow!");
    }
}