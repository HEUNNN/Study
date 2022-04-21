import ch6_class.Tv;

public class ch6_1_TvTest1 {
    public static void main(String[] args) {
        Tv t = new Tv();
        System.out.println("Current Channel: " + t.channel);
        System.out.println("Channel Up: " + t.channelUp());
        System.out.println("Channel Down: " + t.channelDown());
        System.out.println("Current power: " + t.power);
        t.power();
        System.out.println("Convert the Power: " + t.power);
    }
}