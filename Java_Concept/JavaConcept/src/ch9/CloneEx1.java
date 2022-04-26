package ch9;

public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point)original.clone(); // original에 clone() 처리를 하고 반환 받은 Object 타입의 obj를 Point 타입으로 타입 변환한다. -> 복제해서 새로운 객체를 생성
        System.out.println(original);
        System.out.println(copy);
        original.x = 10;
        original.y = 100;
        System.out.println(original);
        System.out.println(copy);

    }
}
class Point implements Cloneable { // Cloneable 인터페이스를 구현한 클래스에서만 clone()을 사용할 수 있다.
    int x, y;
    public Point() {
        this(10, 10);
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
    @Override
    public Object clone() { // Object의 clone() 메서드는 CloneNotSupportedException 예외를 throws 한다. -> try-catch로 예외처리를 해주어야 한다.
        Object obj = null;
        try {
            obj = super.clone(); // clone()은 반드시 예외처리를 해주어야 한다.
        } catch (CloneNotSupportedException e) {

        }
        return obj;
    }
}
