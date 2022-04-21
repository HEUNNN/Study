import ch6_class.ParameterTypeClass;

public class ch6_17_ParameterType {
    public static void main(String[] args) {
        // 참조형 매개변수
        System.out.println("참조형 매개변수");
        ParameterTypeClass ptc = new ParameterTypeClass(3, 4);
        System.out.printf("Print original a: %d, b: %d%n", ptc.a, ptc.b);
        change(ptc);
        System.out.printf("Print original a: %d, b: %d%n%n", ptc.a, ptc.b); // 원본이 변경 됨 -> 인스턴스의 주소를 메서드의 파라미터에 전달하기 때문이다.
        // 기본형 매개변수
        System.out.println("기본형 매개변수");
        int x = 1;
        int y = 1;
        System.out.printf("Print original x: %d, y: %d%n", x, y);
        change2(x, y);
        System.out.printf("Print original x: %d, y: %d%n", x, y); // 원본은 변경되지 않음

    }
    public static void change(ParameterTypeClass p) {
        p.a = p.a * 1000;
        p.b = p.b * 1000;
        System.out.printf("change a: %d, b: %d%n", p.a, p.b);
    }
    public static void change2(int x, int y) {
        x = x * 1000;
        y = y * 1000;
        System.out.printf("change2 x: %d, y: %d%n", x, y);
    }
}
