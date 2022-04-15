import kr.UDDT.Animal;
import kr.UDDT.Cat;
import kr.UDDT.Dog;

public class TPC20 {
    public static void main(String[] args) {
        // Dog, Cat(자식) -> Animal(부모)
        Dog d = new Dog();
        d.eat();

        Cat c = new Cat();
        c.eat();
        c.night();

        // Animal <----[Dog.class, Cat.class]
        Animal ani = new Dog();
        ani.eat();

        ani = new Cat();
        ani.eat();
    }
}
