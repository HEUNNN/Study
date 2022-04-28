package ch11;
import java.lang.*;
import java.util.*;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println(set);
        // Person 인스턴스의 멤버변수를 같도록 지정하여 중복되는 데이터로 인식하게 하려고 했지만, 실행결과는 두 인스턴스의 name과 age가 같음에도 불구하고 서로 다른 것으로 인식한다.
        // equals(), hashCode()를 Overriding 하여 해결한다. -> HashSetEx3
    }
}
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {
        this("GilDong-Hong", 20);
    }
    public String toString() {
        return name + " : " + age;
    }
}
