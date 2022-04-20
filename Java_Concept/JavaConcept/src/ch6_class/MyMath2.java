package ch6_class;

public class MyMath2 {
    public long a, b;
    // 인스턴스 메서드
    // 인스턴스 메서드는 인스턴스 변수 a, b를 사용한다.
    public long add1() {
        return a + b;
    }
    public long subtract1() {
        return a - b;
    }
    public long multiply1() {
        return a * b;
    }
    public double divide1() {
        if(b == 0) {
            return 0;
        }
        return a / b;
    }

    // 클래스 메서드(static)
    // 인스턴스 변수가 아닌 지역변수 a,b를 사용한다.
    public static long add2(long a, long b) {
        return a + b;
    }
    public static long subtract2(long a, long b) {
        return a - b;
    }
    public static long multiply2(long a, long b) {
        return a * b;
    }
    public static double divide2(double a, double b) {
        if(b == 0){
            return 0;
        }
        return a / b;
    }

}
