package ch7;

public class InnerEx1 {
    class InstanceInner1 {
        int iv = 100;
        // static int cv = 100; // static 변수를 선언할 수 없다. Error
        final static int CONST = 100; // final static은 상수이므로 허용
    }
    static class StaticInner1 {
        int iv = 200;
        static int cv = 200; // static 클래스에서는 static 멤버 정의 가능
    }
    public void myMethod() {
        class LocalInnter1 {
            int iv = 300;
            // static int cv = 300; // static 변수를 선언할 수 없다. Error
            final static int CONST = 300;

        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner1.CONST);
        System.out.println(StaticInner1.cv);
    }
}
