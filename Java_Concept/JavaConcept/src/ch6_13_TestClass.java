public class ch6_13_TestClass {
    public void instanceMethod() {}
    public static void staticMethod() {}
    public int a = 10;
    public static String str = "apple";

    // 같은 클래스 내의 메서드는 서로 객체의 생성이나 참조변수 없이 직접 호출이 가능하다.
    // 그러나 static 메서드에서는 인스턴스 메서드를 호출할 수 없다.

    // 인스턴스 메서드에서 같은 클래스 내부의 static 메서드, 인스턴스 메서드 호출하기
    public void instanceMethod2() {
        instanceMethod(); // 객체 생성 없이 직접 호출
        staticMethod(); // 참조변수.static메서드 방식이 아닌, 직접 호출
        System.out.println(a);
        System.out.println(str);
    }
    public static void staticMethod2() {
        // instanceMethod(); 에러
        staticMethod();
        // System.out.println(a); static 메서드에서 인스턴스 변수를 사용할 수 없다.
        System.out.println(str);
    }

    public static void main(String[] args) {
        ch6_13_TestClass c = new ch6_13_TestClass();
        c.instanceMethod2();
        // static method는 클래스명.static메서드 로 호출할 수 있다.
        ch6_13_TestClass.staticMethod2();
    }
}
