public class ch6_16_CarTest {
    // 생성자에서 다른 생성자 호출하기
    /*
    * 생성자의 이름으로 클래스 이름 대신 this를 사용해야한다.
    * 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.
    * */
    static class Car {
        String color;
        String gearType;
        int door;

        Car() { // default 생성자
            this("red"); // Car(String color) 생성자를 첫 줄에서 호출
        }
        Car(String color) {
            this("green", "auto", 4); // Car(String color, String gearType, int door) 생성자 호출
            this.color = color;
        }
        Car(String color, String gearType, int door){
            this.color = color;
            this.gearType = gearType;
            this.door = door;
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("blue");
        Car c3 = new Car("orange", "auto", 2);
        System.out.printf("c1) color: %s, gearType: %s, door: %d%n", c1.color, c1.gearType, c1.door);
        System.out.printf("c2) color: %s, gearType: %s, door: %d%n", c2.color, c2.gearType, c2.door);
        System.out.printf("c3) color: %s, gearType: %s, door: %d%n", c3.color, c3.gearType, c3.door);
        /*
        * c1) color: red, gearType: auto, door: 4
        * c2) color: blue, gearType: auto, door: 4
        * c3) color: orange, gearType: auto, door: 2
        * */


    }
}
