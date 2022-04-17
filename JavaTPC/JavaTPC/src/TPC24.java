import kr.TPC.Animal;
import kr.TPC.Cat;
import kr.TPC.Dog;

public class TPC24 {
    public static void main(String[] args) {
        // 다형성 인수
        Dog d = new Dog();
        display(d);
        Cat c = new Cat();
        display(c);

    }
    public static void display(Animal ani){ // ani는 Upcasting
        ani.eat();

        // night()를 사용하기 위해 Downcasting을 하는데, Dog()의 경우 night가 없기 때문에 문제가 발생한다.
        // if 문으로 해결한다.
        if (ani instanceof Cat) { // ani가 Cat 타입으로부터 인스턴스가 생성되면 if 문 조건이 true
            ((Cat)ani).night();
        }
    }
}
