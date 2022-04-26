package ch9;

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Pointtest(1,1), 2.0);
        Circle c2 = c1.shallowcopy();
        Circle c3 = c1.deepCopy();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);

        c1.p.x = 9; // 원본 유지 안됨
        c1.p.y = 9; // 원본 유지 안됨
        c1.r = 100; // 원본 유지가 됨
        System.out.println("c1 변경 후");
        System.out.println("c1 = " + c1); // c1.toString 생략
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
    }
}
class Circle implements Cloneable {
    Pointtest p;
    double r;

    public Circle(Pointtest p, double r) {
        this.p = p;
        this.r = r;
    }
    public Circle shallowcopy() {
        // 얕은 복사 메서드
        Object obj = null;
        try {
            obj = super.clone(); // 조상인 Object의 clone()을 호출한다.
        } catch (CloneNotSupportedException ce) { }
        return (Circle)obj;
    }
    public Circle deepCopy() {
        // 깊은 복사 메서드
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ce) {}
        Circle c = (Circle)obj;
        c.p = new Pointtest(this.p.x, this.p.y);
        return c;
    }
    public String toString() {
        return "[p = " + p + ", r = " + r +"]";
    }
}
class Pointtest {
    int x;
    int y;
    public Pointtest(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pointtest() {
        this(0,0);
    }
    public String toString() {
        return "(" + x + ", " + y +")";
    }
}