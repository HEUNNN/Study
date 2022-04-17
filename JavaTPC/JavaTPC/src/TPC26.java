import kr.poly.Animal;
import kr.poly.Cat;
import kr.poly.Dog;

public class TPC26 {
    public static void main(String[] args) {
        // 추상클래스는 Upcasting 용도이다. 즉, 부모 용도로 사용한다.
        Animal ani1 = new Dog(); // kr.poly의 Animal 클래스는 abstract 추상 클래스라서 상속받는 자식 클래스에서 반드시 eat()을 override 해주어야 한다.
        ani1.eat();
        ani1.move();
        Animal ani2 = new Cat();
        ani2.eat();
        ani2.move();
        ((Cat)ani2).night();
    }
}
