package ch9;

public class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(8011);
        Person p2 = new Person(8011);
        Object p3 = new Object();
        if(p1.equals(p2)) {
            System.out.println("p1과 p2는 같은 사람입니다. (equals()로 비교)");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다. (equals()로 비교)");
        }
        if(p1 == p2) {
            System.out.println("p1과 p2는 같은 사람입니다. ('=='로 비교)");
        } else {
            System.out.println("p1과 p2는 다른 사람입니다. ('=='로 비교)");
        }
        if(p1.equals(p3)) {
            System.out.println("p1과 p3는 같은 사람입니다. (Object 타입의 p3 인스턴스와 비교)");
        }else {
            System.out.println("p1과 p2는 다른 사람입니다. (Object 타입의 p3 인스턴스와 비교)");
        }
        System.out.println();
        // String 클래스는 Object 클래스의 equals()를 String 인스턴스가 갖는 문자열 값을 비교하도록 오버라이딩 되어있다.
        String a1 = "apple";
        String a2 = "apple";
        if(a1.equals(a2)) {
            System.out.println("a1과 a2는 같은 문자열이다.");
        } else {
            System.out.println("a1과 a2는 다른 문자열이다.");
        }
    }
}
class Person {
    long id;
    @Override
    public boolean equals(Object obj) { // (인스턴스) 참조변수의 메모리 주소만 비교하는 equals() 메서드를 override 하였다.
        if(obj instanceof Person) {
            return id == ((Person)obj).id; // obj가 Object 타입이므로 Person으로 형변환이 필요하다.
        } else {
            System.out.println("전달받은 인스턴스의 참조변수 타입은 Person이 아닙니다.");
            return false; // obj가 Person 타입도 아니면 비교해볼 필요가 없다.
        }
    }
    Person(long id) {
        this.id = id;
    }
}
