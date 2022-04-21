package ch7_class;

public class Tv {
    public boolean power;
    public int channel;
    public void power() {
        power = !power;
    }
    public void ChannelUp() {
        ++channel;
    }
    public void ChannelDown() {
        --channel;
    }
}
