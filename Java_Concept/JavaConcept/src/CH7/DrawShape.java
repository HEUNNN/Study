package CH7;

public class DrawShape {
    public static void main(String[] args) {
        Point[] p = new Point[3];
        p[0] = new Point(100, 100);
        p[1] = new Point(140, 50);
        p[2] = new Point(200, 100);

        Triangle t = new Triangle(p);
        Circle c = new Circle(new Point(150, 150), 50);

        t.draw();
        c.draw();
    }
}
class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this(0,0);
    }
    public String GetXY() {
        return "(" + x +", " + y + ")"; // x와 y의 값을 문자열로 반환
    }
}
class Shape {
    public String color = "black";
    public void draw() {
        System.out.printf("[color = %s ]%n", color);
    }
}

class Circle extends Shape{ // Circle은 Shape(도형) -> 상속관계
    public Point center; // Circle은 Point(점)을 가짐 -> 포함관계
    public int r; // 반지름
    public Circle() { // 생성자1
        this(new Point(0,0), 100);
    }
    public Circle(Point center, int r) { // 생성자 2
        this.center = center;
        this.r = r;
    }
    @Override
    public void draw() {
        System.out.printf("[p1 = (%d, %d), r = %d, color = %s]%n", center.x, center.y, r, color);
    }
}

class Triangle extends Shape{
    public Point[] p = new Point[3]; // Point[] 타입의 참조변수 선언, triangle은 꼭지점(point)가 3개라서 배열로 선언
    public Triangle(Point[] p) {
        this.p = p; // Triangle 멤버변수 p에 Point[] p 를 대입한다. = 포함관계
    }
    @Override
    public void draw() {
        System.out.printf("[p1 = %s, p2 = %s, p3 = %s, color = %s]%n", p[0].GetXY(), p[1].GetXY(), p[2].GetXY(), color);
    }
}