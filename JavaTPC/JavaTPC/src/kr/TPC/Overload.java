package kr.TPC;

public class Overload {
    // class 내에 메서드를 만들 때는 public (static) void/String/int.. methodName() {} 형식으로 만든다.
    // 생성자는 public methodName() {} 형식으로 만든다.
    // 클래스 내 멤버변수는 String/int/float.. 변수이름 = 값 할당 형식으로 만든다.
    public static int sum(int a, int b) {
        return a + b;
    }
    public float sum(int a, float b){
        return a + b;
    }
    public float sum(float a, float b){
        return a + b;
    }
}
