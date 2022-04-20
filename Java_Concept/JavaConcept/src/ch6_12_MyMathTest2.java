import ch6_class.MyMath2;

public class ch6_12_MyMathTest2 {
    public static void main(String[] args) {
        // 클래스 메서드(static)
        // 클래스 메서드는 인스턴스 변수를 사용하지않기 때문에 파라미터에 값을 전달해주어야 한다.
        long staticRes1 = MyMath2.add2(4L,3L);
        long staticRes2 = MyMath2.subtract2(4L, 3L);
        long staticRes3 = MyMath2.multiply2(4L, 3L);
        double staticRes4 = MyMath2.divide2(4L, 3L);
        System.out.printf("Static method result, add: %d, sub: %d, multi: %d, div: %f", staticRes1, staticRes2, staticRes3, staticRes4);

        // 인스턴스 메서드
        // 인스턴스 메서드는 인스턴스 변수를 사용하기 때문에 파라미터로 값을 전달해주지 않아도 된다.
        MyMath2 mm = new MyMath2();
        mm.a = 4L;
        mm.b = 3L;
        long instanceRes1 = mm.add1();
        long instanceRes2 = mm.subtract1();
        long instanceRes3 = mm.multiply1();
        double instanceRes4 = mm.divide1();
        System.out.printf("%nInstance method result, add: %d, sub: %d, multi: %d, div: %f", instanceRes1, instanceRes2, instanceRes3, instanceRes4);
    }
}
