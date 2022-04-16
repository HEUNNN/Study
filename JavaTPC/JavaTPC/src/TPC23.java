import kr.UDDT.Animal;
import kr.UDDT.Cat;
import kr.UDDT.Dog;

public class TPC23 {
    public static void main(String[] args) {
        // Upcasting
        // 젤 위 조상인 Ocject 클래스로도 Cat() 생성이 가능함
        // Object cat = new Cat();
        Animal ani = new Cat();
        ani.eat(); // 컴파일 시점 -> Animal의 eat(), 실행 시점 -> Dog의 eat()
        // Downcasting
        Cat cat = (Cat) ani;
        cat.night();

        ani = new Dog();
        ani.eat();

        // 다형성
        // 상위클래스가 하위클래스에게 동일한 메시지로 서로 다르게 동작시키는 원리
        Object o = new Dog(); // Upcasting
        //o.eat(); // Object 클래스에 eat()이 없기때문에 동적바인딩이 안된다.
        // Downcasting 해주면 eat() 실행 가능
        ((Dog)o).eat();
    }
}
