import kr.TPC.Animal;
import kr.TPC.Cat;
import kr.TPC.Dog;

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
