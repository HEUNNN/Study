package ch6_class;

public class Tv {
    public String color;
    public boolean power;
    public int channel;

    public void power() {
        power = !power;
    }
    public int channelUp() {
        return ++channel;
    }
    public int channelDown() {
        return --channel;
    }
}
