package ch11;
import java.util.*;
import java.lang.*;

/*
 * HashSet의 add 메서드는 새로운 요소를 추기하기 전에 중복을 탐지하기 위하여 추가하려는 요소(Object or Collection)의 equals()와 hashCode()를 호출한다.
 * String 인스턴스를 add()할 경우 String class에는 equals()가 문자열이 같으면 true를 반환하도록 이미 오버라이딩이 되어있다.
 * Peron2와 같이 사용자가 필요에 의해 생성한 경우 그 클래스의 인스턴스에 적합한 equals() 를 오버라이딩 해주어야 한다.
 */
public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}
class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object obj) { // HashSet에서 add()를 실행하면 A_person2.equals(B_person2) 처럼 사용 됨
        // Person2 의 두 가지의 인스턴스의 name, age가 같으면 true를 반환하도록 Overriding
        if(obj instanceof Person2) {
            Person2 tmp = (Person2) obj; // tmp = B_person2 인스턴스
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }
    public int hashCode() {
        return (name + age).hashCode();
    }
    public String toString() {
        return name + " : " + age;
    }

}
