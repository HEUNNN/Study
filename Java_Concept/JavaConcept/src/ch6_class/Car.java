package ch6_class;

public class Car {
    public String color;
    public String gearType;
    public int door;

    public Car() {
        this("white", "auto", 4); // this로 다른 생성자를 호출
    }
    public Car(Car c) { // 인스턴스 복사를 위한 생성자
        this(c.color, c.gearType, c.door);
    }
    public Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
