import kr.poly.A;

public class TPC30 {
    public static void main(String[] args) {
        Object a = new A(); // UpCasting
        System.out.println(a.toString()); // override된 toString()이 실행됨
        ((A)a).display(); // DownCasting
        System.out.println(((A)a).toString()); // Overrided toString() 출력
    }
}
