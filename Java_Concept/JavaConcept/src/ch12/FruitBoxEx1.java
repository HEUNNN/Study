package ch12;

import java.util.ArrayList;

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Toy> toyBox = new Box<>();
        // Box<Grape> grapeBox = new Box<Apple>(); 타입 불일치 -> 에러

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); // Fruit의 자손들은 이 메서드의 매개변수가 될 수 있다.

        System.out.println(fruitBox);
    }
}
class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    public void add(T item) {
        list.add(item);
    }
    public T get(int i) {
        return list.get(i);
    }
    public int size() {
        return list.size();
    }
    public String toString() {
        return list.toString();
    }
}
class Fruit {
    public String toString() {
        return "Fruit";
    }
}
class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}
class Grape extends Fruit {
    public String toString() {
        return "Grape";
    }
}
class Toy {
    public String toString() {
        return "Toy";
    }
}