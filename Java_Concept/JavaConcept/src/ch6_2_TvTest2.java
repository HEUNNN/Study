import ch6_class.Tv;

public class ch6_2_TvTest2 {
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        // t1
        t1.channel = 10;
        t1.power = true;
        System.out.print("t1) Current channel: " + t1.channel + "\t");
        System.out.println(", Current power: " + t1.power);

        // t2
        t2.channel = 100;
        t2.power = false;
        System.out.print("t2) Current channel: " + t2.channel );
        System.out.println(", Current power: " + t2.power);

        // t2 = t1 -> t2에 t1이 참조하는 인스턴스의 주소를 대입해줌
        t2 = t1;
        System.out.print("t2) Current channel: " + t2.channel );
        System.out.println(", Current power: " + t2.power);
        // t2를 변경하면 t1도 영향을 받음 -> t2가 t1이 참조하는 인스턴스의 주소를 갖고있어서 참조관계를 만들기 때문이다.
        // 참조 != 복사
        t2.channel = 1000;
        t2.power = false;
        System.out.print("t1) Current channel: " + t1.channel + "\t");
        System.out.println(", Current power: " + t1.power);

    }
}
