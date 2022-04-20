public class ch6_7_PrimitiveParam1 {
    public static void main(String[] args) {
        // 기본형 매개변수
        Data d1 = new Data();
        d1.x = 100;
        System.out.println("기본형 매개변수, main() : x = " + d1.x); // 100
        change1(d1.x); // 1000
        System.out.println("기본형 매개변수, main() : x = " + d1.x); // 100
        System.out.println();
        // 참조형 매개변수 -> 메서드의 파라미터로 참조형 데이터 타입이 들어감
        Data d2 = new Data();
        d2.x = 100;
        System.out.println("참조형 매개변수, main() : x = " + d2.x); // 100
        change2(d2); // 1000
        System.out.println("참조형 매개변수, main() : x = " + d2.x); // 1000

    }
    static void change1(int x) {
        x = 1000;
        System.out.println("기본형 매개변수 Change: " + x);
    }
    static void change2(Data d) { // Data 타입의 참조형 변수를 넘겨주면 객체가 들어있는 주소를 넘겨주는 것이기 때문에 값 변경이 가능하다.
        d.x = 1000;
        System.out.println("참조형 매개변수 Change: " + d.x);
    }
}
class Data {
    int x;
}
