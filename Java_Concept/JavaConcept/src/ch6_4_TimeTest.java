import ch6_class.Time;

public class ch6_4_TimeTest {
    public static void main(String[] args) {
        Time[] time = new Time[3];
        for (int i = 0; i < time.length; i++) {
            time[i] = new Time();
            time[i].setHour(i+5);
            time[i].setMinute(i+23);
            time[i].setSecond(i+35);
            System.out.println("Time) " + time[i].toString());
        }
    }
}
