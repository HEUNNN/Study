package ch9;

public class CloneEx2 {
    public static void main(String[] args) {
        Point2 original = new Point2(3, 5);
        Point2 copy = original.clone(); // 공변 반환타입 사용
        System.out.println(original);
        System.out.println(copy);
        original.x = 10;
        original.y = 100;
        System.out.println(original);
        System.out.println(copy);

    }
}

class Point2 implements Cloneable { // Cloneable 인터페이스를 구현한 클래스에서만 clone()을 사용할 수 있다.
    int x, y;
    public Point2() {
        this(10, 10);
    }
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
    @Override
    // 공변 반환타입 사용
    public Point2 clone() { // Object의 clone() 메서드는 CloneNotSupportedException 예외를 throws 한다. -> try-catch로 예외처리를 해주어야 한다.
        Object obj = null;
        try {
            obj = super.clone(); // clone()은 반드시 예외처리를 해주어야 한다.
        } catch (CloneNotSupportedException e) {

        }
        return (Point2)obj;
    }
}
