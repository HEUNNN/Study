package CH7;

public class SuperTest {
    public static void main(String[] args) {
        Child2 c = new Child2();
        c.method();
        c.printStr();
    }
}
class Parent2 {
    public int x = 10;
    public void printStr() {
        System.out.println("I'am parrent class.");
    }
}
class Child2 extends Parent2 {
    public int x = 20;
    public void method() {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x); // 자손 클래스 Child2에서 선언된 멤버변수 x = 20을 의미한다.
        System.out.println("super.x = " + super.x); // 부모 클래스 Parent2에서 선언된 멤버변수 x = 10을 의미한다.
        // 자손 클래스에서 조상 클래스로부터 상속받은 멤버 변수를 참조하는데 사용되는 참조 변수: super

    }
    @java.lang.Override
    public void printStr() {
        super.printStr();
        System.out.println("I'am child class.");
    }
}
