package CH7_Class;

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
