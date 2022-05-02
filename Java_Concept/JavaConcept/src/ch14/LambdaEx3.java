package ch14;

@FunctionalInterface
interface MyFunction3 {
    public abstract void myMethod();
}

class Outer {
    int val = 10; // Outer.this.val

    class Inner {
        int val = 10; // this.val

        void method(int i) { // 지역변수 i
            int val = 30; // final int val = 30; , 지역변수
            // i = 10; // 상수의 값은 변경할 수 없음
            // 람다식 내에서 참조하는 지역변수는 final이 붙지 않아도 상수로 간주된다.

            // 함수형 인터페이스 & 람다식 구현
            MyFunction3 f = () -> { // 외부 지역변수(i)와 같은 이름의 람다식 매개변수는 허용되지 않는다.
                System.out.println("             i :" + i);
                System.out.println("           val :" + val);
                System.out.println("      this.val :" + this.val); // Inner, Outer class의 인스턴스 변수인 this.val, Outer.this.val은 값을 변경할 수 있다.
                System.out.println("Outer.this.val :" + Outer.this.val);
            };
            f.myMethod();
        }
    } // Inner 클래스의 끝
} // Outer 클래스의 끝
public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}
