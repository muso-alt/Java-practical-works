package Interfaces;

public class Cow implements IVoice{

    @Override
    public void Voice() {
        System.out.println("Moo!");
    }
}