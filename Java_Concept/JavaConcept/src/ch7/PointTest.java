package ch7;

public class PointTest {
}
class point {
    public int x, y;
    public point() {}
    public point(int x, int y) {
        // 컴파일러가 자동으로 super()를 호출해준다.
        this.x = x;
        this.y = y;
    }
    public String printStr() {
        return "x: " + x + ", y: " + y;
    }
}
class point3d extends point {
    public int z;
    public point3d(int x, int y, int z) {
        //super(x,y);
        super(); // point 부모 클래스에 point() 생성자가 있기 때문에 super()로 호출이 가능하다. 없다면 super(x,y)로 호출해야한다.
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String printStr() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}