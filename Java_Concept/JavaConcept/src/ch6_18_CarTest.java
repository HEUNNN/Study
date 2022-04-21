import ch6_class.Car;

public class ch6_18_CarTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(c1); // c1의 복사본 c2 생성
        System.out.printf("c1) color: %s, gearType: %s, door: %d%n",c1.color, c1.gearType, c1.door);
        System.out.printf("c2) color: %s, gearType: %s, door: %d%n",c2.color, c2.gearType, c2.door);
        c1.door = 100;
        System.out.println("c1.door = 100로 변경");
        System.out.printf("c1) color: %s, gearType: %s, door: %d%n",c1.color, c1.gearType, c1.door);
        System.out.printf("c2) color: %s, gearType: %s, door: %d%n",c2.color, c2.gearType, c2.door);
        /*
        * 인스턴스 c2는 c1을 복사하여 생성된 것이다.(같은 주소값을 가리키는 것이 아니다.) 서로 같은 상태이지만,
        * 서로 독립적으로 메모리 공간에 존재하는 독립된 인스턴스이므로 c1의 값이 변경되어도 c2는 영향을 받지 않는다.
        * */
    }
}
