package ch7;

public class DefaultMethodTest {
    public static void main(String[] args) {
        ChildTest c = new ChildTest();
        c.method1();
        c.method2();
        MyInterface1.staticMethod();
        MyInterface2.staticMethod();

    }
}
interface MyInterface1 {
    default void method1() {
        System.out.println("method1() in MyInterface1");
    }
    default void method2() {
        System.out.println("method2() in MyInterface1");
    }
    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface1");
    }
}
interface MyInterface2 {
    default void method2() {
        System.out.println("method1() in MyInterface2");
    }
    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface2");
    }
}
class ParentTest {
    public void method1() {
        System.out.println("method1() in ParentTest");
    }
}
class ChildTest extends ParentTest implements MyInterface1, MyInterface2 {
    public void method2() {
        System.out.println("Overrided, method1() in Child");
    }
}