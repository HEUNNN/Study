import ch6_class.Test;

public class TestClass {

    public static void main(String[] args) {
        printHello();
        // printHi(); 는 static이 아니여서 바로 사용 불가능
        TestClass tc = new TestClass();
        tc.printHi();

        Test.print();
        Test t = new Test(3, 4);
        t.print2();
        System.out.println("t.a = " + t.a + "t.b = " + t.b);
    }
    public static void printHello() {
        System.out.println("Hello");

    }
    public void printHi() {
        System.out.println("Hi");
        printHello();

    }
}
