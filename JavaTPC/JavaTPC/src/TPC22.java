import kr.UDDT.Animal;
import kr.UDDT.Cat;
import kr.UDDT.Dog;

public class TPC22 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.eat();
        cat.eat();

        // Downcasting
        Cat c = (Cat)cat;
        c.night();
//        ((Cat)cat).night();
    }
}
