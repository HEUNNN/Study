package ch12;

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox3<Fruit> fruitBox3 = new FruitBox3<>();
        FruitBox3<Apple> appleBox3 = new FruitBox3<>();

        fruitBox3.add(new Grape());
        fruitBox3.add(new Apple());
        appleBox3.add(new Apple());
        appleBox3.add(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox3));
        System.out.println(Juicer.makeJuice(appleBox3));

    }
}
class FruitBox3<T extends Fruit> extends Box<T>{}
class Juice {
    String name;
    public Juice(String name) {
        this.name = name + " Juice";
    }
    public String toString() {
        return name;
    }
}
class Juicer {
    static Juice makeJuice(FruitBox3<? extends Fruit> box) { 
        String tmp = " ";
        for(Fruit f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}