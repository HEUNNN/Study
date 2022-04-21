package CH7_Class;

public class PointOverride extends Point2{
    public int z;
    @Override // 이름이 같고, 매개변수가 같고, 반환타입이 같아서 오버라이딩 조건을 만족한다.
    public String getLocation() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}
class Point2 {
    public int x;
    public int y;
    public String getLocation() {
        return "x: " + x + ", y: " + y;
    }
}
