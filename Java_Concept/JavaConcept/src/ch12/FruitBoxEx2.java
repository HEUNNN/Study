package ch12;

interface Eatable {}
public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox2<Fruit> fruitBox2 = new FruitBox2<>();
        FruitBox2<Apple> appleBox2 = new FruitBox2<>();
        FruitBox2<Grape> grapeBox2 = new FruitBox2<>();
//        FruitBox2<Toy> toyBox2 = new FruitBox2<Toy>(); //Toy class는 Fruit class의 자손도 아니고, Etable 인터페이스를 구현한것도 아니라서 오류 발생

        fruitBox2.add(new Fruit());
        fruitBox2.add(new Apple());
        fruitBox2.add(new Grape());

        appleBox2.add(new Apple());
//        appleBox2.add(new Grape()); // Grape class는 Apple class의 자손이 아니다.
    }
}
class FruitBox2<T extends Fruit & Eatable> extends Box<T> {
    // FruitBox2의 타입변수는 Fruit class 와 Eatable interface로 제한된다. FruitBox2는 Box<T> 클래스를 상속받는다.
}