import kr.UDDT.Animal;
import kr.UDDT.Cat;
import kr.UDDT.Dog;

public class TPC21 {
    public static void main(String[] args) {
        Animal d=new Dog(); // 상속 관계 -> Upcasting
        d.eat(); // 동적 바인

        Animal c = new Cat();
        c.eat();
        // c.night(); 는 불가 Animal 클래스에는 night()가 없기 때문이다.
        // Animal Date Type에서 Cat Data Type으로 타입 변경이 필요하다.
        ((Cat)c).night(); // -> Downcasting
    }
}
